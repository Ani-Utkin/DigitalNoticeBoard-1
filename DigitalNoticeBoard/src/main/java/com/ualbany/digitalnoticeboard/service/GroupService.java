package com.ualbany.digitalnoticeboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.model.Group;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository repository;
	
	public void save(Group entity) {
		repository.save(entity);
	}
	
	public List<Group> getUserGroups(User user)
	{
		return repository.findbyUser(user);
	
	}
	
	public Optional<Group> getById(Long id)
	{
		return repository.findById(id);
	}
}
