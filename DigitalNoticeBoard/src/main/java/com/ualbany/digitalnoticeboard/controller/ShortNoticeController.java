package com.ualbany.digitalnoticeboard.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ualbany.digitalnoticeboard.model.Channel;
import com.ualbany.digitalnoticeboard.model.ShortNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.service.ChannelService;
import com.ualbany.digitalnoticeboard.service.NoticeService;
import com.ualbany.digitalnoticeboard.service.ShortNoticeService;
import com.ualbany.digitalnoticeboard.service.UserService;

@Controller
public class ShortNoticeController extends BaseController {

	@Autowired
	ChannelService channelService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	ShortNoticeService shortNoticeService;
	
	@InitBinder("shortNoticeForm")
	public void experitationDateBinding(WebDataBinder binder )
	{
	    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm aa");
	    binder.registerCustomEditor(Date.class,"expirationDate", new CustomDateEditor(simpleDateFormat,true));	   
	}
	
	@GetMapping(value = "/{username}/notice/addShortNotice")
    public ModelAndView addShortNoticeGetRequest(@PathVariable final String username, @ModelAttribute("shortNoticeForm") ShortNotice noticeForm, BindingResult bindingResult, Model model) {
		User user = userService.findByUsername(username);
	    ModelAndView mv = new ModelAndView("addshortnotice");
        mv.addObject("user", user);
        return mv;
    }
	 
	@PostMapping("/{username}/notice/addShortNotice")
    public ModelAndView addShortNoticePutRequest(@PathVariable final String username, @ModelAttribute("shortNoticeForm") ShortNotice noticeForm, BindingResult bindingResult, Model model) {
		User user = userService.findByUsername(username);
		
		SimpleDateFormat sdf =new SimpleDateFormat("HH:mm");
		try {
			Date date = sdf.parse(noticeForm.getExpirationTime());
			Calendar cal = Calendar.getInstance();
			Date now = cal.getTime();
			cal.setTime(date);
	    	int hh = cal.get(Calendar.HOUR_OF_DAY);
	    	int mm = cal.get(Calendar.MINUTE);
	    	int ss = cal.get(Calendar.SECOND);
	    	cal.setTime(now);
	        cal.set(Calendar.HOUR_OF_DAY, hh);
	        cal.set(Calendar.MINUTE, mm);
	        cal.set(Calendar.SECOND, ss);
			noticeForm.setExpirationDate(cal.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setpersistableproperties(noticeForm, user);
		shortNoticeService.save(noticeForm);
        
		ModelAndView mv = new ModelAndView("userhome");
		mv.addObject("user", user);
        List<Channel> channels = channelService.getAllPublicChannels();
        mv.addObject("Channels", channels);
        List<ShortNotice> shortnotices = shortNoticeService.getAllActiveNotices();
        mv.addObject("ShortNotices", shortnotices);
        return mv;
    }
}
