package com.ualbany.digitalnoticeboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.model.GroupInvitation;
import com.ualbany.digitalnoticeboard.model.InivitationStatus;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.repository.GroupInvitationRepository;

@Service
public class GroupIniviationService {

	@Autowired
	private GroupInvitationRepository repository;
	
	public void save(GroupInvitation entity) {
		repository.save(entity);
	}
	
	public List<GroupInvitation> getUserRecivedInvites(User receiver, InivitationStatus status)
	{
		return repository.findByReceiverAndInivitationStatus(receiver, status);
	}
	
	public List<GroupInvitation> getUserSentInvites(User sender, InivitationStatus status)
	{
		return repository.findBySenderAndInivitationStatus(sender, status);
	}
	
	public Optional<GroupInvitation> getById(Long id){
		return repository.findById(id);
	}
}
