package com.ualbany.digitalnoticeboard.service;

import java.util.List;

import com.ualbany.digitalnoticeboard.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    List<User> findByEmail(String email);
    User findById(Long id);
}
