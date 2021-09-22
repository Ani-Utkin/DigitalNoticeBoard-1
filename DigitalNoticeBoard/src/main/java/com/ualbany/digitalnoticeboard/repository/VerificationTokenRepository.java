package com.ualbany.digitalnoticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.ualbany.digitalnoticeboard.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, String> {
    List<VerificationToken> findByUserEmail(String email);
    List<VerificationToken> findByToken(String token);
}
