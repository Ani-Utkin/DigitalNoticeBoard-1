package com.ualbany.digitalnoticeboard.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ualbany.digitalnoticeboard.model.GroupShortNotice;
import com.ualbany.digitalnoticeboard.model.User;

public interface GroupShortNoticeRepository extends JpaRepository<GroupShortNotice, Long> {
	public List<GroupShortNotice> findByCreatedBy(User user);
	public Optional<GroupShortNotice> findByIdAndCreatedBy(Long id, User user);
	public List<GroupShortNotice> findByExpirationDateAfterOrderByExpirationDateAsc(Date date);
}
