package com.example.otrs.Service;

import com.example.otrs.Entity.User;
import com.example.otrs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserDetails(int userId) {
        return userRepository.getUserDetails(userId);
    }
}
