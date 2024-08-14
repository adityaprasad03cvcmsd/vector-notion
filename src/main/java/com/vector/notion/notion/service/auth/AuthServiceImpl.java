package com.vector.notion.notion.service.auth;

import com.vector.notion.notion.dto.user.LoginRequest;
import com.vector.notion.notion.dto.user.SignupRequest;
import com.vector.notion.notion.entity.User;
import com.vector.notion.notion.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    UserService userService;


    @Override
    public String signup(SignupRequest request) {
        User user = User.builder().userName(request.getUserName()).email(request.getEmail())
                .password(request.getPassword()).createdAt(new Date()).build();
        return userService.addUser(user);
    }

    @Override
    public String login(LoginRequest request) throws AccountNotFoundException {
        User user = userService.verifyUser(request);
        if(user == null){
            throw new AccountNotFoundException("user account not found");
        }
        return user.getId().toString();
    }
}
