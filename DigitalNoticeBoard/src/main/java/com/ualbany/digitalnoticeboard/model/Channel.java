package com.ualbany.digitalnoticeboard.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"title"}) })
public class Channel extends Persistable {

	private String title;
	private String description;
	
	List<Notice> notices = new ArrayList<Notice>();
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(mappedBy = "channels")
	public List<Notice> getNotices(){
		return this.notices;
	}
	
	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}
}
