package com.ualbany.digitalnoticeboard.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Notice extends Persistable {
	
	private String title;
	private String summary;
	private String details;
	private Date expirationDate;
	
	private List<Channel> channels = new ArrayList<Channel>();
	private List<User> bookmarkusers = new ArrayList<User>();
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}	
	
	@ManyToMany
    @JoinTable(name = "Notice_Channel",joinColumns= @JoinColumn(name="noticeId", referencedColumnName="id"),
    	    inverseJoinColumns= @JoinColumn(name="channelId", referencedColumnName="id"))
	public List<Channel> getChannels(){
		return this.channels;
	}
	
	public void setChannels(List<Channel> channels){
		this.channels = channels;
	}

	@ManyToMany
    @JoinTable(name = "Bookmark_Users",joinColumns= @JoinColumn(name="noticeId", referencedColumnName="id"),
    	    inverseJoinColumns= @JoinColumn(name="userId", referencedColumnName="id"))
	public List<User> getBookmarkusers() {
		return bookmarkusers;
	}

	public void setBookmarkusers(List<User> bookmarkusers) {
		this.bookmarkusers = bookmarkusers;
	}
}
