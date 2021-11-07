package com.ualbany.digitalnoticeboard.repository;

import com.ualbany.digitalnoticeboard.model.Profile;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	Optional<Profile> findByUserId(Long id);
}
