package com.ualbany.digitalnoticeboard.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
