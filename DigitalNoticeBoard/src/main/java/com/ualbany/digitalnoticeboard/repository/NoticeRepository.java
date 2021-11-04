package com.ualbany.digitalnoticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ualbany.digitalnoticeboard.model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
