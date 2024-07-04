package com.example.otrs.Controller;

import com.example.otrs.Entity.Ticket;
import com.example.otrs.Service.TicketService;
import com.example.otrs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUserDetails")
    public List<Ticket> getDetails(int userId){
        return userService.getUserDetails(userId);
    }
}
