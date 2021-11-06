package com.ualbany.digitalnoticeboard.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Channel extends Persistable {

	private String title;
	private String description;
	private Visibility visibility;
	
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

	/**
	 * @return the visibility
	 */
	public Visibility getVisibility() {
		return visibility;
	}

	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
}
