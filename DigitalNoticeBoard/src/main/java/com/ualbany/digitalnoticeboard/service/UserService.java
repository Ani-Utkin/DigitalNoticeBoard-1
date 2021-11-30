package com.ualbany.digitalnoticeboard.service;

import com.ualbany.digitalnoticeboard.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    User findByEmail(String email);
    User findById(Long id);
}
