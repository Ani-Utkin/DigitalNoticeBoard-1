package com.ualbany.digitalnoticeboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.model.Group;
import com.ualbany.digitalnoticeboard.model.GroupMember;
import com.ualbany.digitalnoticeboard.model.GroupNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.repository.GroupMemberRepository;

@Service
public class GroupMemberService {

	@Autowired
	private GroupMemberRepository repository;
	
	public void save(GroupMember entity) {
		repository.save(entity);
	}
	
	public List<GroupMember> getGroupMembers(Group group)
	{
		return repository.findByGroup(group);
	}
	
	public List<GroupMember> getUserGroups(User user)
	{
		return repository.findByUser(user);
	}
	
	public Optional<GroupMember> getMemberByUserAndGroup(User user, Group group){
		return repository.findByUserAndGroup(user, group);
	}
	
	 public void deletemember(Optional<GroupMember> member) {
    	if(member.isPresent()) {
    		repository.delete(member.get());    		
    	}
    }
}
