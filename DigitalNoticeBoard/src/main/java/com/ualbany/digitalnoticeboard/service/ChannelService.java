package com.ualbany.digitalnoticeboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.repository.ChannelRepository;

@Service
public class ChannelService {
	
	@Autowired
	private ChannelRepository repository;

}
