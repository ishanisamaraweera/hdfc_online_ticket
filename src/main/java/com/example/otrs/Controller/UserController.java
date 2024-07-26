package com.example.otrs.Controller;

import com.example.otrs.DTO.UserDTO;
import com.example.otrs.DTO.UserDetailsDTO;
import com.example.otrs.Entity.User;
import com.example.otrs.Entity.UserRole;
import com.example.otrs.Entity.UserFunction;
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
    public User getDetailsByUsername(@PathVariable String username) {
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
    public User addUser(@RequestBody UserDTO userRequest) {
        return userService.createUserWithRoles(userRequest);
    }

    @PostMapping("/addUserRole")
    public UserRole addUserRole(@RequestBody UserRole userRole) {
        return userService.addUserRole(userRole);
    }

    @PostMapping("/addFunction")
    public UserFunction addFunction(@RequestBody UserFunction userFunction) {
        return userService.addFunction(userFunction);
    }
}
