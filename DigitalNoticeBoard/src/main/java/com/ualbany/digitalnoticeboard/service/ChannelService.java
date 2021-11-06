package com.ualbany.digitalnoticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.model.Channel;
import com.ualbany.digitalnoticeboard.model.Visibility;
import com.ualbany.digitalnoticeboard.repository.ChannelRepository;

@Service
public class ChannelService {
	
	@Autowired
	private ChannelRepository repository;

	public void save(Channel entity) {
		repository.save(entity);
	}
	
	public List<Channel> getAllPublicChannels(){
		return repository.findByVisibility(Visibility.PUBLIC);
	}
}
