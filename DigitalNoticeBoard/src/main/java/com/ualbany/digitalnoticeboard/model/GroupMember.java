package com.ualbany.digitalnoticeboard.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class GroupMember extends Persistable {
	
	private Group group;
	private User user;
	private GroupMemberRole role;
	
	@ManyToOne
	@JoinColumn(name="groupId", nullable=false)
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
	
	@ManyToOne
	@JoinColumn(name="userId", nullable=false)
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public GroupMemberRole getRole() {
		return role;
	}

	public void setRole(GroupMemberRole role) {
		this.role = role;
	}

}
