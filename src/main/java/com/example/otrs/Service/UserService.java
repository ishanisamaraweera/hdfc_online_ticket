package com.example.otrs.Service;

import com.example.otrs.DTO.UserDetailsDTO;
import com.example.otrs.Entity.User;
import com.example.otrs.Repository.UserDetailsRepository;
import com.example.otrs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsRepository userDetailsRepository;

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

    public User saveDetails(User user) {
        user.setUsername(user.getEpf());
        user.setPassword(user.getEpf() + user.getDob().replace("-",""));
        user.setAddedBy("1428");
        user.setAddedDateTime(LocalDateTime.now().toString());
        user.setLastUpdatedUser("1428");
        user.setLastUpdatedDateTime(LocalDateTime.now().toString());

        userDetailsRepository.saveDetails(
                user.getUsername(),
                user.getPassword(),
                user.getDisplayName(),
                user.getEpf(),
                user.getDesignation(),
                user.getDob(),
                user.getLocation(),
                user.getBranchDivision(),
                user.getAddedBy(),
                user.getAddedDateTime(),
                user.getLastUpdatedUser(),
                user.getLastUpdatedDateTime()
        );
        return user;
    }
}
