package com.example.otrs.Service;

import com.example.otrs.DTO.UserDetailsDTO;
import com.example.otrs.Entity.User;
import com.example.otrs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserDetailsByUsername(String username) {
        return userRepository.getUserDetailsByUsername(username);
    }

    public UserDetailsDTO getUserDetailsForTicketByUsername(String username) {
        return userRepository.getUserDetailsForTicketByUsername(username);
    }

    public String getIPAddress() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        return localHost.getHostAddress();
    }

    public UserDetailsDTO getIssueTypes(String username) {
        return userRepository.getUserDetailsForTicketByUsername(username);
    }
}
