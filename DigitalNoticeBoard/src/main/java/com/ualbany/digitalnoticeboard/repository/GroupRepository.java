package com.ualbany.digitalnoticeboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ualbany.digitalnoticeboard.model.Group;
import com.ualbany.digitalnoticeboard.model.User;

public interface GroupRepository extends JpaRepository<Group, Long> {

	@Query("select grp from Group grp join grp.members mem where mem.user =:user")
	public List<Group> findbyUser(@Param("user") User user);
}
