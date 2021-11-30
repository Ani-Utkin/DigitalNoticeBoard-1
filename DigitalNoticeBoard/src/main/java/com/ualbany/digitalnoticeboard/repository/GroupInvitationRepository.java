package com.ualbany.digitalnoticeboard.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ualbany.digitalnoticeboard.model.Group;
import com.ualbany.digitalnoticeboard.model.GroupInvitation;
import com.ualbany.digitalnoticeboard.model.InivitationStatus;
import com.ualbany.digitalnoticeboard.model.User;

public interface GroupInvitationRepository extends JpaRepository<GroupInvitation, Long> {

	public List<GroupInvitation> findBySenderAndInivitationStatus(User sender, InivitationStatus status);
	public List<GroupInvitation> findByReceiverAndInivitationStatus(User receiver, InivitationStatus status);
	public List<GroupInvitation> findByGroupId(Group groupId);
}
