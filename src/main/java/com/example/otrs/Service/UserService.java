package com.example.otrs.Service;

import com.example.otrs.DTO.UserDTO;
import com.example.otrs.DTO.UserDetailsDTO;
import com.example.otrs.Entity.User;
import com.example.otrs.Entity.UserRoleAssign;
//import com.example.otrs.Entity.UserRoleAssignId;
import com.example.otrs.Entity.UserRoleAssignId;
import com.example.otrs.Repository.UserRepository;
import com.example.otrs.Repository.UserRoleAssignRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleAssignRepository userRoleAssignRepository;

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

        userRepository.saveDetails(
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

    @Transactional
    public User createUserWithRoles(UserDTO userRequest) {
        User user = new User();
        // Set user fields from userRequest
        user.setUsername(userRequest.getEpf());
        user.setDisplayName(userRequest.getDisplayName());
        user.setPassword(userRequest.getEpf() + userRequest.getDob().replace("-", ""));
        user.setLocation(userRequest.getLocation());
        user.setBranchDivision(userRequest.getBranchDivision());
        user.setDesignation(userRequest.getDesignation());
        user.setAddedBy(userRequest.getAddedBy());
        user.setAddedDateTime(userRequest.getAddedDateTime());
        user.setLastUpdatedUser(userRequest.getLastUpdatedUser());
        user.setLastUpdatedDateTime(userRequest.getLastUpdatedDateTime());
        user.setDob(userRequest.getDob());
        user.setEpf(userRequest.getEpf());
        List<String> roles = userRequest.getUserRoles();
        userRepository.save(user);

        for (String role : roles) {
            UserRoleAssignId id = new UserRoleAssignId(user.getUsername(), role);
            UserRoleAssign userRoleAssign = new UserRoleAssign(id);
            userRoleAssignRepository.save(userRoleAssign);
        }
        return user;
    }
}
