package com.ualbany.digitalnoticeboard.controller;

import java.util.Date;

import com.ualbany.digitalnoticeboard.model.Persistable;
import com.ualbany.digitalnoticeboard.model.Status;
import com.ualbany.digitalnoticeboard.model.User;

public class BaseController {

	protected void setpersistableproperties(Persistable ps, User user) {
		Date now = new Date();
		ps.setCreatedAt(now);
		ps.setUpdatedAt(now);
		ps.setCreatedBy(user);
		ps.setUpdatedBy(user);
		ps.setStatus(Status.ACTIVE);
	}
}
