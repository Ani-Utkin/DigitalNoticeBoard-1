package com.ualbany.digitalnoticeboard.controller;

import java.util.Collections;
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
import com.ualbany.digitalnoticeboard.model.Group;
import com.ualbany.digitalnoticeboard.model.Role;
import com.ualbany.digitalnoticeboard.model.ShortNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.model.UserRoleType;
import com.ualbany.digitalnoticeboard.service.ChannelService;
import com.ualbany.digitalnoticeboard.service.GroupService;
import com.ualbany.digitalnoticeboard.service.ShortNoticeService;
import com.ualbany.digitalnoticeboard.service.UserService;
import com.ualbany.digitalnoticeboard.service.VerificationTokenService;
import com.ualbany.digitalnoticeboard.validator.SignInValidator;
import com.ualbany.digitalnoticeboard.validator.SignUpValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    private SignUpValidator signupValidator;
    
    @Autowired
    private SignInValidator signinValidator;
    
    @Autowired
	ChannelService channelService;
	
	@Autowired
	ShortNoticeService shortNoticeService;
	
	@Autowired
	GroupService groupService;

    @GetMapping("/signup")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "signup";
    }

    @PostMapping("/signup")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
        signupValidator.validate(userForm, bindingResult);

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
    	signinValidator.validate(userForm, bindingResult);
    	if (bindingResult.hasErrors()) {
            return new ModelAndView("signin");
        }
    	User user = userService.findByUsername(userForm.getUsername());
    	ModelAndView mv = new ModelAndView("userhome");
    	mv.addObject("user", user);
    	List<Channel> channels = channelService.getChannelsWithValidNotices();
    	mv.addObject("Channels", channels);
    	List<ShortNotice> shortnotices = shortNoticeService.getAllActiveNotices();
        Collections.sort(shortnotices, (o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate()));
    	mv.addObject("ShortNotices", shortnotices);
    	List<Group> groups = groupService.getUserGroups(user);
    	mv.addObject("groups", groups);
        return mv;
    }
    
    @GetMapping("/signin")
    public String getSignIn(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
        return "signin";
    }
    
    @GetMapping("/signout")
    public ModelAndView getSignOut() {
    	 ModelAndView mv = new ModelAndView("home");
         List<Channel> channels = channelService.getChannelsWithValidNotices();
         mv.addObject("Channels", channels);
         List<ShortNotice> shortnotices = shortNoticeService.getAllActiveNotices();
         Collections.sort(shortnotices, (o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate()));
         mv.addObject("ShortNotices", shortnotices);
         
         return mv;
    }
    
    @GetMapping("/resetPassword")
    public String getResetPassword(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
        return "signin";
    }
    
    @PostMapping("/resetPassword")
    public ModelAndView putResetPassword(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) {
    	signinValidator.validate(userForm, bindingResult);
    	if (bindingResult.hasErrors()) {
            return new ModelAndView("signin");
        }
    	User usr = userService.findByUsername(userForm.getUsername());
    	usr.setPassword(userForm.getPasswordConfirm());
    	ModelAndView mv = new ModelAndView("userhome");
    	mv.addObject("user", userForm);
    	List<Channel> channels = channelService.getChannelsWithValidNotices();
    	mv.addObject("Channels", channels);
    	List<ShortNotice> shortnotices = shortNoticeService.getAllActiveNotices();
    	Collections.sort(shortnotices, (o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate()));
    	mv.addObject("ShortNotices", shortnotices);
    	List<Group> groups = groupService.getUserGroups(userForm);
    	mv.addObject("groups", groups);
    	return mv;
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
