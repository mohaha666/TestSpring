package com.my.service;

import com.my.domain.User;
import com.my.repo.UserRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserRepo userRepo;

    public boolean hasMatchUser(String userName, String password) {
        List<User> users = userRepo.hasMatchUser(userName, password);
        return users.size()>0 ? true:false;
    }


    public User findUserByUserName(String userName){
        return userRepo.findUserByUserName(userName);
    }
}
