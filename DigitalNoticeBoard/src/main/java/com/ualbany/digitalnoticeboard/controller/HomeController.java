package com.ualbany.digitalnoticeboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ualbany.digitalnoticeboard.model.Channel;
import com.ualbany.digitalnoticeboard.model.ShortNotice;
import com.ualbany.digitalnoticeboard.service.ChannelService;
import com.ualbany.digitalnoticeboard.service.ShortNoticeService;

@Controller
public class HomeController {

	@Autowired
	ChannelService channelService;
	
	@Autowired
	ShortNoticeService shortNoticeService;
	
	@GetMapping("/home")
    public ModelAndView profileGet(Model model) {
        ModelAndView mv = new ModelAndView("home");
        List<Channel> channels = channelService.getAllPublicChannels();
        mv.addObject("Channels", channels);
        List<ShortNotice> shortnotices = shortNoticeService.getAllPublicNotices();
        mv.addObject("ShortNotices", shortnotices);
        return mv;
    }
}
