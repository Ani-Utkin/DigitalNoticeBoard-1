package com.ualbany.digitalnoticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.model.ShortNotice;
import com.ualbany.digitalnoticeboard.model.Visibility;
import com.ualbany.digitalnoticeboard.repository.ShortNoticeRepository;

@Service
public class ShortNoticeService {
	
	@Autowired
	private ShortNoticeRepository repository;
	
	public void Save(ShortNotice entity) {
		repository.save(entity);
	}
	
	public List<ShortNotice> getAllPublicNotices(){
		return repository.findByVisibility(Visibility.PUBLIC);
	}
}
