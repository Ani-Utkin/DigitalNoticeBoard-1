package com.ualbany.digitalnoticeboard.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "UserGroup")
public class Group extends Persistable {
	
	String name;
	List<User> members = new ArrayList<User>();
	List<User> admins = new ArrayList<User>();
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany
    @JoinTable(name = "Group_Members",joinColumns= @JoinColumn(name="groupId", referencedColumnName="id"),
    inverseJoinColumns= @JoinColumn(name="memberId", referencedColumnName="id"),
    uniqueConstraints = @UniqueConstraint(columnNames = {"groupId", "memberId" }))
	public List<User> getMembers(){
		return this.members;
	}
	
	public void setMembers(List<User> members){
		this.members = members;
	}
	
	@ManyToMany
    @JoinTable(name = "Group_Admins",joinColumns= @JoinColumn(name="groupId", referencedColumnName="id"),
    	    inverseJoinColumns= @JoinColumn(name="adminId", referencedColumnName="id"),
    	    uniqueConstraints = @UniqueConstraint(columnNames = {"groupId", "adminId" }))
	public List<User> getAdmins(){
		return this.admins;
	}
	
	public void setAdmins(List<User> admins) {
		this.admins = admins;
	}
}
