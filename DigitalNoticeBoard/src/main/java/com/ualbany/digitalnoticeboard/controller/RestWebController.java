package com.ualbany.digitalnoticeboard.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ualbany.digitalnoticeboard.model.Notice;
import com.ualbany.digitalnoticeboard.model.Response;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.repository.NoticeRepository;
import com.ualbany.digitalnoticeboard.service.NoticeService;
import com.ualbany.digitalnoticeboard.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class RestWebController extends BaseController {

	@Autowired
	UserServiceImpl userService; 
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	NoticeRepository noticeRepo;

	@PostMapping("/bookmarkNotice")
    public Response bookmarkNoticePutRequest(@RequestBody String request) {
		JSONObject bookmarkrequest = new JSONObject(request.toString());
		Response response = new Response("Done", bookmarkrequest);
		
		User user = userService.findByUsername(bookmarkrequest.getString("username"));
		Notice notice = noticeService.getByNoticeId(bookmarkrequest.getLong("noticeId"));
		Set<Notice> noticeSet = new HashSet<Notice>(user.getBookmarkednotices());
		if(noticeSet.contains(notice))
			return response;
		
		List<User> bookmarkedusers= notice.getBookmarkusers();
		bookmarkedusers.add(user);
		notice.setBookmarkusers(bookmarkedusers);
		List<Notice> bookmarknotices = user.getBookmarkednotices();
		bookmarknotices.add(notice);
		user.setBookmarkednotices(bookmarknotices);
		
		userService.save(user);
		noticeService.save(notice);
		// Create Response Object
		
		
		return response;
    }
}