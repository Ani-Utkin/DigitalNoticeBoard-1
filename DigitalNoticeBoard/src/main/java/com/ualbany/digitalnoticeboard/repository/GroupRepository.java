package com.ualbany.digitalnoticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ualbany.digitalnoticeboard.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
