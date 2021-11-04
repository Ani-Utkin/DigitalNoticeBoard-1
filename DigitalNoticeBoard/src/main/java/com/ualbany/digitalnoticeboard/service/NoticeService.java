package com.ualbany.digitalnoticeboard.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.model.Notice;
import com.ualbany.digitalnoticeboard.repository.NoticeRepository;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeRepository repository;
	
	public void save(Notice p) {
    	repository.save(p);
    }

    public Notice findById(Long id) {
    	Optional<Notice> notice= repository.findById(id);
    	if(notice.isPresent())
    		return notice.get();
    	else
    		return null;
    }

}
