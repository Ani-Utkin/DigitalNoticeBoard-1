package com.ualbany.digitalnoticeboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ualbany.digitalnoticeboard.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository repository;
}
