package com.ualbany.digitalnoticeboard.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ualbany.digitalnoticeboard.model.Channel;
import com.ualbany.digitalnoticeboard.model.Role;
import com.ualbany.digitalnoticeboard.model.ShortNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.model.UserRoleType;
import com.ualbany.digitalnoticeboard.service.ChannelService;
import com.ualbany.digitalnoticeboard.service.ShortNoticeService;
import com.ualbany.digitalnoticeboard.service.UserService;
import com.ualbany.digitalnoticeboard.service.VerificationTokenService;
import com.ualbany.digitalnoticeboard.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
	ChannelService channelService;
	
	@Autowired
	ShortNoticeService shortNoticeService;

    @GetMapping("/signup")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "signup";
    }

    @PostMapping("/signup")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "signup";
        }
        Date now = new Date();
        Role role = new Role();
        role.setCreatedAt(now);
        role.setUpdatedAt(now);
        role.setRoleType(UserRoleType.USER);
        
        userForm.addRole(role);
        userForm.setCreatedAt(now);
        userForm.setUpdatedAt(now);
        userService.save(userForm);

       model.addAttribute("verificationForm", userForm);

        verificationTokenService.createVerification(userForm.getEmail());
        return "verification-form";
    }

    @GetMapping("/verify-email")
    @ResponseBody
    public String verifyEmail(String code) {
        return verificationTokenService.verifyEmail(code).getBody();
    }
    
    @PostMapping("/signin")
    public ModelAndView postSignIn(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
    	ModelAndView mv = new ModelAndView("userhome");
    	mv.addObject("user", userForm);
    	List<Channel> channels = channelService.getAllPublicChannels();
    	mv.addObject("Channels", channels);
    	List<ShortNotice> shortnotices = shortNoticeService.getAllPublicNotices();
    	mv.addObject("ShortNotices", shortnotices);
        return mv;
    }
    
    @GetMapping("/signin")
    public String getSignIn(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
        return "signin";
    }
    
    @GetMapping("/mynoticetab")
    public String mynoticetab(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
        return "mynoticetab";
    }
    
    @GetMapping("/postShortnotice")
    public String postShortnotice(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
        return "postShortnotice";
    }
}
