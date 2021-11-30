package com.ualbany.digitalnoticeboard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ualbany.digitalnoticeboard.model.Group;
import com.ualbany.digitalnoticeboard.model.GroupMember;
import com.ualbany.digitalnoticeboard.model.User;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
	public List<GroupMember> findByGroup(Group group);
	public List<GroupMember> findByUser(User user);
	public Optional<GroupMember> findByUserAndGroup(User user, Group group);
	
}
