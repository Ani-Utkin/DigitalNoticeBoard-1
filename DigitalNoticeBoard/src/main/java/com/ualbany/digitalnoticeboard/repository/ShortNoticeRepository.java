package com.ualbany.digitalnoticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ualbany.digitalnoticeboard.model.ShortNotice;

public interface ShortNoticeRepository extends JpaRepository<ShortNotice, Long> {

}
