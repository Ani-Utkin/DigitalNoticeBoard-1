package com.ualbany.digitalnoticeboard.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "UserGroup")
public class Group extends Persistable {
	
	String name;
	List<GroupMember> members = new ArrayList<GroupMember>();
	List<GroupNotice> notices = new ArrayList<GroupNotice>();
	List<GroupShortNotice> shortNotices = new ArrayList<GroupShortNotice>();
	
	@OneToMany(mappedBy="group")
	public List<GroupShortNotice> getShortNotices() {
		return shortNotices;
	}

	public void setShortNotices(List<GroupShortNotice> shortNotices) {
		this.shortNotices = shortNotices;
	}

	@OneToMany(mappedBy="group")
	public List<GroupNotice> getNotices() {
		return notices;
	}

	public void setNotices(List<GroupNotice> notices) {
		this.notices = notices;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy="group")
	public List<GroupMember> getMembers(){
		return this.members;
	}
	
	public void setMembers(List<GroupMember> members){
		this.members = members;
	}
}
