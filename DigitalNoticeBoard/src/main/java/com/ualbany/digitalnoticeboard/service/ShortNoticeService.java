package com.ualbany.digitalnoticeboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.repository.ShortNoticeRepository;

@Service
public class ShortNoticeService {
	
	@Autowired
	private ShortNoticeRepository repository;
	

}
