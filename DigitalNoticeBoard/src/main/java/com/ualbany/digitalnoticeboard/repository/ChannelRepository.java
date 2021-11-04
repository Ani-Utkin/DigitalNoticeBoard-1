package com.ualbany.digitalnoticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ualbany.digitalnoticeboard.model.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {

}
