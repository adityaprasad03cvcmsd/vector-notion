package com.vector.notion.notion.service.auth;

import com.vector.notion.notion.dto.user.LoginRequest;
import com.vector.notion.notion.dto.user.SignupRequest;

import javax.security.auth.login.AccountNotFoundException;

public interface AuthService {

    String signup(SignupRequest request);

    String login(LoginRequest request) throws AccountNotFoundException;
}
