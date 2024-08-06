package com.example.otrs.Service;

import com.example.otrs.DTO.*;
import com.example.otrs.Entity.*;
import com.example.otrs.Repository.UserFunctionRepository;
import com.example.otrs.Repository.UserRepository;
import com.example.otrs.Repository.UserRoleAssignRepository;
import com.example.otrs.Repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/*

@author ishani.s
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserFunctionRepository userFunctionRepository;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
        user.setPassword(passwordEncoder.encode(userRequest.getEpf() + userRequest.getDob().replace("-", "")));
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
        user.setInitialLogin("Yes");

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

    public boolean authenticateUser(LoginDTO loginInfo) {
        User user = userRepository.getUserDetailsByUsername(loginInfo.getUsername());
        if (user != null) {
            return passwordEncoder.matches(loginInfo.getPassword(), user.getPassword());
        }
        return false;
    }

    public boolean changePassword(String username, String oldPassword, String newPassword, String confirmPassword) {
        User user = userRepository.getUserDetailsByUsername(username);
        if (user != null && passwordEncoder.matches(oldPassword, user.getPassword()) && newPassword.equals(confirmPassword)) {
            user.setPassword(passwordEncoder.encode(newPassword));
            user.setInitialLogin("No");
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public boolean matchesPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public String checkInitialLoginStatus(String username){
        return userRepository.checkInitialLoginStatus(username);
    }

    public List<UserDataDTO> getAllUserDetails() {
        List<Object[]> results = userRepository.getAllUserDetails();
        List<UserDataDTO> users = new ArrayList<>();

        for (Object[] result : results) {
            UserDataDTO user = new UserDataDTO();
            user.setUsername((String) result[0]);
            user.setDisplayName((String) result[1]);
            user.setDesignation((String) result[2]);
            user.setDob((String) result[3]);
            user.setEpf((String) result[4]);
            user.setLocation((String) result[5]);
            user.setBranchDivision((String) result[6]);
            user.setAddedBy((String) result[7]);
            user.setAddedDateTime((String) result[8]);
            user.setLastUpdatedUser((String) result[9]);
            user.setLastUpdatedDateTime((String) result[10]);
            user.setStatus((String) result[11]);
            users.add(user);
        }
        return users;
    }
}