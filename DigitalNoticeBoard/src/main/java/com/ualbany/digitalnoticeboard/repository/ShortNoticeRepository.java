package com.ualbany.digitalnoticeboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ualbany.digitalnoticeboard.model.ShortNotice;
import com.ualbany.digitalnoticeboard.model.User;
import com.ualbany.digitalnoticeboard.model.Status;

public interface ShortNoticeRepository extends JpaRepository<ShortNotice, Long> {
	
	public List<ShortNotice> findByStatus(Status status);
	public List<ShortNotice> findByCreatedBy(User user);

}
