package com.ualbany.digitalnoticeboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.model.Notice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.repository.NoticeRepository;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeRepository repository;
	
	public void save(Notice p) {
    	repository.save(p);
    }

    public Notice getByNoticeId(Long id) {
    	Optional<Notice> notice= repository.findById(id);
    	if(notice.isPresent())
    		return notice.get();
    	else
    		return null;
    }
    
    public List<Notice> getUserCreatedNotices(User user) {
    	return repository.findByCreatedBy(user);
    }
}
