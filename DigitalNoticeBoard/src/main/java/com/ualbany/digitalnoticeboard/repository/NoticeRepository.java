package com.ualbany.digitalnoticeboard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ualbany.digitalnoticeboard.model.Notice;
import com.ualbany.digitalnoticeboard.model.User;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
	public List<Notice> findByCreatedBy(User user);
	public Optional<Notice> findByIdAndCreatedBy(Long id, User user);
}
