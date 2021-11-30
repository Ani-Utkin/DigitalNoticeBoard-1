package com.ualbany.digitalnoticeboard.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class GroupInvitation extends Persistable {

	User sender;
	User receiver;
	Group group;
	InivitationStatus inivitationStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "senderId")
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiverId")
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "groupId")
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public InivitationStatus getInivitationStatus() {
		return inivitationStatus;
	}
	public void setInivitationStatus(InivitationStatus inivitationStatus) {
		this.inivitationStatus = inivitationStatus;
	}
}
