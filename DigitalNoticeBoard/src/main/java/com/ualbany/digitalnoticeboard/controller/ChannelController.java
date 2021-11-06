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
import org.springframework.web.servlet.ModelAndView;

import com.ualbany.digitalnoticeboard.model.Channel;
import com.ualbany.digitalnoticeboard.model.Persistable;
import com.ualbany.digitalnoticeboard.model.ShortNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.model.Visibility;
import com.ualbany.digitalnoticeboard.service.ChannelService;
import com.ualbany.digitalnoticeboard.service.ShortNoticeService;
import com.ualbany.digitalnoticeboard.service.UserService;

@Controller
public class ChannelController {

	@Autowired
	ChannelService channelService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	ShortNoticeService shortNoticeService;
	
	@GetMapping(value = "/{username}/channel/add")
    public ModelAndView channelAddGet(@PathVariable final String username, @ModelAttribute("channelForm") Channel channelForm, BindingResult bindingResult,  Model model) {
		User user = userService.findByUsername(username);
	    ModelAndView mv = new ModelAndView("addchannel");
	    List<Visibility> visibilityOptions = new ArrayList<Visibility>();
	    visibilityOptions.add(Visibility.PUBLIC);
	    visibilityOptions.add(Visibility.PRIVATE);
        mv.addObject("user", user);
        mv.addObject("visibilityTypes", visibilityOptions);
        return mv;
    }
	 
	@PostMapping("/{username}/channel/add")
    public ModelAndView channelAddPut(@PathVariable final String username, @ModelAttribute("channelForm") Channel channelForm, BindingResult bindingResult, Model model) {
		User user = userService.findByUsername(username);
		setpersistableproperties(channelForm, user);
        channelService.save(channelForm);
        
		ModelAndView mv = new ModelAndView("userhome");
		mv.addObject("user", user);
        List<Channel> channels = channelService.getAllPublicChannels();
        mv.addObject("Channels", channels);
        List<ShortNotice> shortnotices = shortNoticeService.getAllPublicNotices();
        mv.addObject("ShortNotices", shortnotices);
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
