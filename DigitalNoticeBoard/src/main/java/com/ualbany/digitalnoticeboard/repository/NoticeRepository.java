package com.ualbany.digitalnoticeboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ualbany.digitalnoticeboard.model.Notice;
import com.ualbany.digitalnoticeboard.model.User;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
	public List<Notice> findByCreatedBy(User user);
}
