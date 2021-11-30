package com.ualbany.digitalnoticeboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.model.GroupNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.repository.GroupNoticeRepository;

@Service
public class GroupNoticeService {
	
	@Autowired
	private GroupNoticeRepository repository;
	
	public void save(GroupNotice p) {
    	repository.save(p);
    }

    public GroupNotice getByNoticeId(Long id) {
    	Optional<GroupNotice> notice= repository.findById(id);
    	if(notice.isPresent())
    		return notice.get();
    	else
    		return null;
    }
    
    public List<GroupNotice> getUserCreatedNotices(User user) {
    	return repository.findByCreatedBy(user);
    }
    
    public void deleteNoticeById(Long id) {
    	Optional<GroupNotice> notice= repository.findById(id);
    	if(notice.isPresent()) {
    		repository.delete(notice.get());    		
    	}
    }
}
