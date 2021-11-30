package com.ualbany.digitalnoticeboard.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ualbany.digitalnoticeboard.model.Channel;
import com.ualbany.digitalnoticeboard.model.ShortNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.service.ChannelService;
import com.ualbany.digitalnoticeboard.service.ShortNoticeService;
import com.ualbany.digitalnoticeboard.service.UserService;

@Controller
public class HomeController extends BaseController{

	@Autowired
	ChannelService channelService;
	
	@Autowired
	ShortNoticeService shortNoticeService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"/", "/home"})
    public ModelAndView homeGet(Model model) {
        ModelAndView mv = new ModelAndView("home");
        List<Channel> channels = channelService.getAllPublicChannels();
        mv.addObject("Channels", channels);
        List<ShortNotice> shortnotices = shortNoticeService.getAllActiveNotices();
        Collections.sort(shortnotices, (o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate()));

        mv.addObject("ShortNotices", shortnotices);
        return mv;
    }
	
	@GetMapping(value = "/{username}/userhome")
    public ModelAndView userHomeGet(@PathVariable final String username, Model model) {
		User user = userService.findByUsername(username);
		ModelAndView mv = new ModelAndView("userhome");
		mv.addObject("user", user);
        List<Channel> channels = channelService.getAllPublicChannels();
        mv.addObject("Channels", channels);
        List<ShortNotice> shortnotices = shortNoticeService.getAllActiveNotices();
        Collections.sort(shortnotices, (o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate()));
        
        mv.addObject("ShortNotices", shortnotices);
        return mv;
    }
}
