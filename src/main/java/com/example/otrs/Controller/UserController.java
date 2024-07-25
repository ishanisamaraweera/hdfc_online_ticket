package com.example.otrs.Controller;

import com.example.otrs.DTO.UserDetailsDTO;
import com.example.otrs.Entity.User;
import com.example.otrs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @CrossOrigin(origins = "*")

    @GetMapping("/getUserDetailsByUsername/{username}")
    public User getDetailsByUsername(@PathVariable String username){
        return userService.getUserDetailsByUsername(username);
    }

    @GetMapping("/getUserDetailsForTicketByUsername/{username}")
    public UserDetailsDTO getUserDetailsForTicketByUsername(@PathVariable String username) {
        return userService.getUserDetailsForTicketByUsername(username);
    }

    @GetMapping("/getIPAddress")
    public String getIPAddress() throws UnknownHostException {
        return userService.getIPAddress();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.saveDetails(user);
    }
}
