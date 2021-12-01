package com.ualbany.digitalnoticeboard.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ualbany.digitalnoticeboard.model.Channel;
import com.ualbany.digitalnoticeboard.model.Status;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
	public List<Channel> findByStatus(Status status);
	
	@Query("select distinct channel from Channel channel join channel.notices notice where notice.expirationDate >=:expirationDate")
	public List<Channel> findByNoticeExpirationDateGraterThanEqual(@Param("expirationDate") Date date);
	
	@Query("select channel from Channel channel where channel.title in (:titles)")
	public List<Channel> findbyTitles(@Param("titles")List<String> titles);
	
	@Query("select channel.title from Channel channel")
	public List<String> findAllTitles();
	
	public Optional<Channel> findByTitle(String title);
}
