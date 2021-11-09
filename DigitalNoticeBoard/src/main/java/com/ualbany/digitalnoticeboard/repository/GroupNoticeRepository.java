package com.ualbany.digitalnoticeboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ualbany.digitalnoticeboard.model.GroupShortNotice;
import com.ualbany.digitalnoticeboard.model.User;

public interface GroupNoticeRepository extends JpaRepository<GroupShortNotice, Long> {
	public List<GroupShortNotice> findByCreatedBy(User user);
}
