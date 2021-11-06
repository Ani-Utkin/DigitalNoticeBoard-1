package com.ualbany.digitalnoticeboard.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ualbany.digitalnoticeboard.model.Channel;
import com.ualbany.digitalnoticeboard.model.Notice;
import com.ualbany.digitalnoticeboard.model.Persistable;
import com.ualbany.digitalnoticeboard.model.Response;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.repository.ChannelRepository;
import com.ualbany.digitalnoticeboard.repository.NoticeRepository;
import com.ualbany.digitalnoticeboard.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class RestWebController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ChannelRepository channelRepo;
	
	@Autowired
	NoticeRepository noticeRepo;

	@PostMapping(value = "/channel/add")
	public Response postCustomer(@RequestBody String channel) {
		// cust.add(customer);
		JSONObject jsonChannel = new JSONObject(channel.toString());

		Channel chl = new Channel();
		User user = userRepo.findById(jsonChannel.getLong("userId")).get();
		setpersistableproperties(chl, user);
		chl.setTitle(jsonChannel.getString("title"));
		chl.setDescription(jsonChannel.getString("description"));
		channelRepo.save(chl);
		// Create Response Object
		Response response = new Response("Done", jsonChannel);
		return response;
	}
	
	@PostMapping(value = "/notice/add")
	public Response postNotice(@RequestBody String notice) {
		// cust.add(customer);
		JSONObject jsonOrder = new JSONObject(notice.toString());

		Notice nt = new Notice();
		User user = userRepo.findById(jsonOrder.getLong("userId")).get();
		setpersistableproperties(nt, user);
		nt.setTitle(jsonOrder.getString("title"));
		nt.setDetails(jsonOrder.getString("details"));
		
		try {
			nt.setExpirationDate(DateUtils.parseDate(jsonOrder.getString("expirationDate"), 
					  new String[] { "yyyy-MM-dd HH:mm:ss", "dd-MM-yyyy" }));
		} catch (JSONException e) {
			nt.setExpirationDate(new Date());
			e.printStackTrace();
		} catch (ParseException e) {
			nt.setExpirationDate(new Date());
			e.printStackTrace();
		}
		
		JSONArray jsonitems = jsonOrder.getJSONArray("channels");
		List<Channel> channels = new ArrayList<Channel>();
		for (int i = 0; i < jsonitems.length(); i++) {
			JSONObject jsonitem = jsonitems.getJSONObject(i);
			Channel channel = channelRepo.findById(jsonitem.getLong("channelId")).get();
			channels.add(channel);
		}
		
		nt.setChannels(channels);
		nt.setSummary(jsonOrder.getString("summary"));
		
		noticeRepo.save(nt);
		// Create Response Object
		Response response = new Response("Done", jsonOrder);
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