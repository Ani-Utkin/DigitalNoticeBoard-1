package com.ualbany.digitalnoticeboard.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.model.GroupShortNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.repository.GroupShortNoticeRepository;

@Service
public class GroupShortNoticeService {
	
	@Autowired
	private GroupShortNoticeRepository repository;
	
	public void save(GroupShortNotice entity) {
		repository.save(entity);
	}
	
	public List<GroupShortNotice> getAllActiveNotices(){
		Date now = new Date();
		return repository.findByExpirationDateAfterOrderByExpirationDateAsc(now);
	}
	
	 public List<GroupShortNotice> getUserCreatedNotices(User user) {
	    	return repository.findByCreatedBy(user);
	    }

	public void deleteShortNoticeById(Long id) {
		Optional<GroupShortNotice> shortNotice=	repository.findById(id);
		if(shortNotice.isPresent()) {
    		repository.delete(shortNotice.get());    		
		}	
	}
}
