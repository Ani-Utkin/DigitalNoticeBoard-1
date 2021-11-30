package com.ualbany.digitalnoticeboard.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ualbany.digitalnoticeboard.model.GroupNotice;
import com.ualbany.digitalnoticeboard.model.User;

public interface GroupNoticeRepository extends JpaRepository<GroupNotice, Long> {
	public List<GroupNotice> findByCreatedBy(User user);
}
