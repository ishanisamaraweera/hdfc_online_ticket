package com.example.otrs.Service;

import com.example.otrs.DTO.UserDTO;
import com.example.otrs.DTO.UserDetailsDTO;
import com.example.otrs.Entity.*;
import com.example.otrs.Repository.UserFunctionRepository;
import com.example.otrs.Repository.UserRepository;
import com.example.otrs.Repository.UserRoleAssignRepository;
import com.example.otrs.Repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserFunctionRepository userFunctionRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

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
        user.setAddedBy("1428");
        user.setAddedDateTime(userRequest.getAddedDateTime());
        user.setLastUpdatedUser("1428");
        user.setLastUpdatedDateTime(userRequest.getLastUpdatedDateTime());
        user.setDob(userRequest.getDob());
        user.setEpf(userRequest.getEpf());
        List<String> roles = userRequest.getUserRoles();
        user.setStatus(userRequest.getStatus());

        userRepository.save(user);

        for (String role : roles) {
            UserRoleAssignId id = new UserRoleAssignId(user.getUsername(), role);
            UserRoleAssign userRoleAssign = new UserRoleAssign(id);
            userRoleAssignRepository.save(userRoleAssign);
        }
        return user;
    }

    @Transactional
    public UserRole addUserRole(UserRole userRole){
        return userRoleRepository.save(userRole);
    }

    @Transactional
    public UserFunction addFunction(UserFunction userFunction){
        return userFunctionRepository.save(userFunction);
    }

//    public boolean authenticateUser(String username, String rawPassword) {
//        User user = userRepository.getUserDetailsByUsername(username);
//        if (user != null) {
//            return passwordEncoder.matches(rawPassword, user.getPassword());
//        }
//        return false;
//    }
//
//    public boolean changePassword(String username, String oldPassword, String newPassword, String confirmPassword) {
//        User user = userRepository.getUserDetailsByUsername(username);
//        if (user != null && passwordEncoder.matches(oldPassword, user.getPassword()) && newPassword.equals(confirmPassword)) {
//            user.setPassword(passwordEncoder.encode(newPassword));
//            userRepository.save(user);
//            return true;
//        }
//        return false;
//    }
//
//    public String encodePassword(String rawPassword) {
//        return passwordEncoder.encode(rawPassword);
//    }
//
//    public boolean matchesPassword(String rawPassword, String encodedPassword) {
//        return passwordEncoder.matches(rawPassword, encodedPassword);
//    }
}
