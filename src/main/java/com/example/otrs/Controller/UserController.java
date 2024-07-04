package com.example.otrs.Controller;

import com.example.otrs.Entity.User;
import com.example.otrs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUserDetails")
    public User getDetails(int userId){
        return userService.getUserDetails(userId);
    }
}
