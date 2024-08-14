package com.vector.notion.notion.service.user;

import com.vector.notion.notion.dto.user.LoginRequest;
import com.vector.notion.notion.entity.User;

public interface UserService {

    String addUser(User user);

    User getUser(Long id);

    User verifyUser(LoginRequest login);
}
