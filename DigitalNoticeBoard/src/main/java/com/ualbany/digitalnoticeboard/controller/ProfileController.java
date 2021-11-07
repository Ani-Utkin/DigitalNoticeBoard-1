package com.ualbany.digitalnoticeboard.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ualbany.digitalnoticeboard.model.Channel;
import com.ualbany.digitalnoticeboard.model.Persistable;
import com.ualbany.digitalnoticeboard.model.Profile;
import com.ualbany.digitalnoticeboard.model.ShortNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.model.Visibility;
import com.ualbany.digitalnoticeboard.service.ProfileService;
import com.ualbany.digitalnoticeboard.service.UserService;

@Controller
@RequestMapping
public class ProfileController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping(value = "/{username}/profile")
    public ModelAndView userProfileGet(@PathVariable final String username, Model model) {
		User user = userService.findByUsername(username);
		ModelAndView mv = new ModelAndView("profile");
		mv.addObject("user", user);
		
		Profile profile = profileService.findByUserId(user.getId());
		if(profile == null) {
			profile = new Profile();
			setpersistableproperties(profile, user);
			profile.setUser(user);
			profileService.save(profile);
		}
		mv.addObject("profile", profile);
        return mv;
    }
	
	@GetMapping(value = "/{username}/profile/edit")
    public ModelAndView profileEditGetRequest(@PathVariable final String username, @ModelAttribute("profileForm") Profile profileForm, BindingResult bindingResult, Model model) {
		User user = userService.findByUsername(username);
		Profile profile = profileService.findByUserId(user.getId());
	    ModelAndView mv = new ModelAndView("editprofile");
        mv.addObject("user", user);
        mv.addObject("profile", profile);
        return mv;
    }
	 
	@PostMapping(value = "/{username}/profile/edit")
    public ModelAndView profileEditPutRequest(@PathVariable final String username, @ModelAttribute("profileForm") Profile profileForm, BindingResult bindingResult, Model model) {
		User user = userService.findByUsername(username);
		Profile profile = profileService.findByUserId(user.getId());
		profile.setFirstName(profileForm.getFirstName());
		profile.setLastName(profileForm.getLastName());
		profile.setAddress1(profileForm.getAddress1());
		profile.setAddress2(profileForm.getAddress2());
		profile.setPhone(profileForm.getPhone());
		profile.setImage(profileForm.getImage());
		Date now = new Date();
		profile.setUpdatedAt(now);
		profileService.save(profileForm);
        
		ModelAndView mv = new ModelAndView("profile");
		mv.addObject("user", user);
        mv.addObject("profile", profileForm);
        return mv;
    }
	
	void setpersistableproperties(Persistable ps, User user) {
		Date now = new Date();
		ps.setCreatedAt(now);
		ps.setUpdatedAt(now);
		ps.setCreatedBy(user);
		ps.setUpdatedBy(user);
	}

}
