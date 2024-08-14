package com.vector.notion.notion.service.user;

import com.vector.notion.notion.dto.user.LoginRequest;
import com.vector.notion.notion.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private List<User> userList;

    @PostConstruct
    private void init(){
        userList = new ArrayList<>();
    }


    @Override
    public String addUser(User user) {
        Long id = Long.valueOf(userList.size());
        user.setId(id);
        userList.add(user);
        return id.toString();
    }

    @Override
    public User getUser(Long id) {
        for(User user: userList){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public User verifyUser(LoginRequest login) {
        for(User user: userList){
            if(user.getUserName().equals(login.getUserName()) && user.getPassword().equals(login.getPassword())){
                return user;
            }
        }
        return null;
    }
}
