package com.ualbany.digitalnoticeboard.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ShortNotice extends Persistable{
	
	private String details;
	private Date expirationDate;
	private String expirationTime;
	private Visibility visibility;
	
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
	public String getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}	

}
