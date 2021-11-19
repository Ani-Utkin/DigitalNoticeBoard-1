package com.ualbany.digitalnoticeboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.model.ShortNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.model.Status;
import com.ualbany.digitalnoticeboard.repository.ShortNoticeRepository;

@Service
public class ShortNoticeService {
	
	@Autowired
	private ShortNoticeRepository repository;
	
	public void save(ShortNotice entity) {
		repository.save(entity);
	}
	
	public List<ShortNotice> getAllActiveNotices(){
		return repository.findByStatus(Status.ACTIVE);
	}
	
	 public List<ShortNotice> getUserCreatedNotices(User user) {
	    	return repository.findByCreatedBy(user);
	    }

	public void deleteShortNoticeById(User user, Long id) {
		Optional<ShortNotice> shortNotice=	repository.findByIdAndCreatedBy(id,user);
		if(shortNotice.isPresent()) {
    		repository.delete(shortNotice.get());    		
		}	
	}
}
