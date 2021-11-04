package com.ualbany.digitalnoticeboard.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ShortNotice extends Persistable{
	
	private String details;
	private Date expirationDate;
	
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

}
