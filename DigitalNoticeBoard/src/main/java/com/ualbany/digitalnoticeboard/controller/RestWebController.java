package com.ualbany.digitalnoticeboard.controller;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ualbany.digitalnoticeboard.model.Notice;
import com.ualbany.digitalnoticeboard.model.Persistable;
import com.ualbany.digitalnoticeboard.model.Response;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.repository.NoticeRepository;
import com.ualbany.digitalnoticeboard.service.NoticeService;
import com.ualbany.digitalnoticeboard.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class RestWebController {

	@Autowired
	UserServiceImpl userService; 
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	NoticeRepository noticeRepo;

	@PostMapping("/bookmarkNotice")
    public Response bookmarkNoticePutRequest(@RequestBody String request) {
		JSONObject bookmarkrequest = new JSONObject(request.toString());
		User user = userService.findByUsername(bookmarkrequest.getString("username"));
		Notice notice = noticeService.findById(bookmarkrequest.getLong("noticeId"));
		List<User> bookmarkedusers= notice.getBookmarkusers();
		bookmarkedusers.add(user);
		notice.setBookmarkusers(bookmarkedusers);
		List<Notice> bookmarknotices = user.getBookmarkednotices();
		bookmarknotices.add(notice);
		user.setBookmarkednotices(bookmarknotices);
		
		userService.save(user);
		noticeService.save(notice);
        
		// Create Response Object
		Response response = new Response("Done", bookmarkrequest);
		return response;
    }
	
	
	void setpersistableproperties(Persistable ps, User user) {
		Date now = new Date();
		ps.setCreatedAt(now);
		ps.setUpdatedAt(now);
		ps.setCreatedBy(user);
		ps.setUpdatedBy(user);
	}
}