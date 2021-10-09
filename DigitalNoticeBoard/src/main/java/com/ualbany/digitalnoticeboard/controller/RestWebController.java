package com.ualbany.digitalnoticeboard.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ualbany.digitalnoticeboard.model.Persistable;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class RestWebController {

	@Autowired
	UserRepository userrepo;

	void setpersistableproperties(Persistable ps, User user) {
		Date now = new Date();
		ps.setCreatedAt(now);
		ps.setUpdatedAt(now);
		ps.setCreatedBy(user);
		ps.setUpdatedBy(user);
	}
}