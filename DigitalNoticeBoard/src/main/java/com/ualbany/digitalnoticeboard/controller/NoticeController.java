package com.ualbany.digitalnoticeboard.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ualbany.digitalnoticeboard.model.Channel;
import com.ualbany.digitalnoticeboard.model.Notice;
import com.ualbany.digitalnoticeboard.model.ShortNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.service.ChannelService;
import com.ualbany.digitalnoticeboard.service.NoticeService;
import com.ualbany.digitalnoticeboard.service.ShortNoticeService;
import com.ualbany.digitalnoticeboard.service.UserService;

@Controller
public class NoticeController extends BaseController {

	@Autowired
	ChannelService channelService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	ShortNoticeService shortNoticeService;
	
	@GetMapping(value = "/{username}/notice/addNotice")
    public ModelAndView addNoticeGetRequest(@PathVariable final String username, @ModelAttribute("noticeForm") Notice noticeForm, BindingResult bindingResult, Model model) {
		User user = userService.findByUsername(username);
	    ModelAndView mv = new ModelAndView("addnotice");
	    List<Channel> publicChannels = channelService.getAllPublicChannels();
        mv.addObject("user", user);
        mv.addObject("channels", publicChannels);
        return mv;
    }
	 
	@PostMapping("/{username}/notice/addNotice")
    public ModelAndView addNoticePutRequest(@PathVariable final String username, @ModelAttribute("noticeForm") Notice noticeForm, BindingResult bindingResult, Model model) {
		User user = userService.findByUsername(username);
		setpersistableproperties(noticeForm, user);
        noticeService.save(noticeForm);
        
		ModelAndView mv = new ModelAndView("userhome");
		mv.addObject("user", user);
        List<Channel> channels = channelService.getAllPublicChannels();
        mv.addObject("Channels", channels);
        List<ShortNotice> shortnotices = shortNoticeService.getAllActiveNotices();
        Collections.sort(shortnotices, (o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate()));

        mv.addObject("ShortNotices", shortnotices);
        return mv;
    }
	
	@GetMapping("/{username}/notice/addedNotices")
    public ModelAndView addedNoticesGetRequest(@PathVariable final String username, Model model) {
		User user = userService.findByUsername(username);
        return getNoticeList(user);
    }
	public ModelAndView getNoticeList(User user) {
		
        List<Notice> notices= noticeService.getUserCreatedNotices(user);
        List<ShortNotice> shortnotices = shortNoticeService.getUserCreatedNotices(user);
        Collections.sort(shortnotices, (o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate()));

		
		ModelAndView mv = new ModelAndView("addednotices");
		mv.addObject("user", user);
		mv.addObject("notices", notices);      
        mv.addObject("ShortNotices", shortnotices);
        return mv;
	}
	@GetMapping("/{username}/notice/deletenotice/{id}")
    public ModelAndView deleteNoticesById(@PathVariable final String username,@PathVariable final Long id, Model model) {
		User user = userService.findByUsername(username);
       noticeService.deleteNoticeById(user, id);
        return getNoticeList(user);
    }
}
