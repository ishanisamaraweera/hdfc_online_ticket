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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
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
    @Autowired
    private UserRoleAssignRepository userRoleAssignRepository;
    @Autowired
    private EmailSenderService emailSenderService;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User getUserDetailsByUsername(String username) {
        return userRepository.getUserDetailsByUsername(username);
    }

    public String getDisplayNameByUsername(String username) {
        return userRepository.getDisplayNameByUsername(username);
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
        String password = userRequest.getEpf() + userRequest.getDob().replace("-", "");

        // Set user fields from userRequest
        user.setUsername(userRequest.getEpf());
        user.setDisplayName(userRequest.getDisplayName());
        user.setPassword(passwordEncoder.encode(password));
        user.setLocation(userRequest.getLocation());
        user.setBranchDivision(userRequest.getBranchDivision());
        user.setDesignation(userRequest.getDesignation());
        user.setAddedBy("1428");
        user.setAddedDateTime(userRequest.getAddedDateTime());
        user.setLastUpdatedUser("1428");
        user.setLastUpdatedDateTime(userRequest.getLastUpdatedDateTime());
        user.setDob(userRequest.getDob());
        user.setEpf(userRequest.getEpf());
        user.setEmail(userRequest.getEmail());
        List<String> roles = userRequest.getUserRoles();
        user.setStatus(userRequest.getStatus());
        user.setInitialLogin("Yes");

        userRepository.save(user);

        for (String role : roles) {
            UserRoleAssignId id = new UserRoleAssignId(user.getUsername(), role);
            UserRoleAssign userRoleAssign = new UserRoleAssign(id);
            userRoleAssignRepository.save(userRoleAssign);
        }

        emailSenderService.sendEmail(user.getEmail(), "Initial User Password",
                ("Dear " + user.getDisplayName() + ","
                        + "\n\nYour OTRS username = " + user.getUsername()
                        + "\nYour OTRS temporary password = " + password
                        + "\n\nPlease login to the system using above credentials and reset the password when your initial login."
                        + "\n\nThank you.!"
                        + "\nHDFC Bank")
                );
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
        User user = userRepository.getUserDetailsByUsernameToAuthenticate(loginInfo.getUsername());
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
            user.setEmail((String) result[5]);
            user.setLocation((String) result[6]);
            user.setBranchDivision((String) result[7]);
            user.setAddedBy((String) result[8]);
            user.setAddedDateTime((String) result[9]);
            user.setLastUpdatedUser((String) result[10]);
            user.setLastUpdatedDateTime((String) result[11]);
            user.setStatus((String) result[12]);
            users.add(user);
        }
        return users;
    }

    public List<UserRoleDTO> getAllUserRoles() {
        List<Object[]> results = userRoleRepository.getAllUserRoles();
        List<UserRoleDTO> userRoles = new ArrayList<>();

        for (Object[] result : results) {
            UserRoleDTO userRole = new UserRoleDTO();
            userRole.setUserRoleId((String) result[0]);
            userRole.setUserRoleDes((String) result[1]);
            userRole.setCreatedUser((String) result[2]);
            userRole.setCreatedDateTime((String) result[3]);
            userRole.setLastUpdatedUser((String) result[4]);
            userRole.setLastUpdatedDateTime((String) result[5]);
            userRole.setStatus((String) result[6]);
            userRoles.add(userRole);
        }
        return userRoles;
    }

    public List<String> getUserRolesForUsername(String username) {
        return userRepository.getUserRolesForUsername(username);
    }

    public UserRole getUserDetailsByUserRole(String userRoleId){
        return userRoleRepository.getUserDetailsByUserRole(userRoleId);
    }

    public User updateUser(User user) throws Exception {
        User updateUser = userRepository.findById(user.getUsername()).orElse(null);

        if (updateUser == null) {
            throw new Exception("User not found");
        }
        updateUser.setDisplayName(user.getDisplayName());
        updateUser.setDesignation(user.getDesignation());
        updateUser.setEmail(user.getEmail());
        updateUser.setDob(user.getDob());
        updateUser.setLocation(user.getLocation());
        updateUser.setBranchDivision(user.getBranchDivision());
        updateUser.setStatus(user.getStatus());
        updateUser.setLastUpdatedUser(user.getLastUpdatedUser());
        updateUser.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        userRepository.save((updateUser));
        return updateUser;
    }

    public UserRole updateUserRole(UserRole userRole) throws Exception {
        UserRole updateUserRole = userRoleRepository.findById(userRole.getUserRoleId()).orElse(null);

        if (updateUserRole == null) {
            throw new Exception("User not found");
        }
        updateUserRole.setUserRoleDes(userRole.getUserRoleDes());
        updateUserRole.setStatus(userRole.getStatus());
        updateUserRole.setLastUpdatedUser(userRole.getLastUpdatedUser());
        updateUserRole.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        userRoleRepository.save((updateUserRole));
        return updateUserRole;
    }


    @Transactional
    public boolean assignUserRoles(String username, List<String> userRoles) {
        userRoleAssignRepository.deleteExistingUserRoles(username);

        for (String userRole : userRoles) {
            UserRoleAssignId id = new UserRoleAssignId(username, userRole);
            UserRoleAssign userRoleAssign = new UserRoleAssign(id);
            userRoleAssignRepository.save(userRoleAssign);
        }
        return true;
    }

    public void deleteUser(String username) throws Exception {
        User deleteUser = userRepository.findById(username).orElse(null);

        if (deleteUser == null) {
            throw new Exception("User not found");
        }
        deleteUser.setStatus(6);
        deleteUser.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        userRepository.save((deleteUser));
    }

    public void deleteUserRole(String userRoleId) throws Exception {
        UserRole deleteUserRole = userRoleRepository.findById(userRoleId).orElse(null);

        if (deleteUserRole == null) {
            throw new Exception("User not found");
        }
        deleteUserRole.setStatus(6);
        deleteUserRole.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        userRoleRepository.save((deleteUserRole));
    }

    public List<UserNameDTO> getUserListsByUserRole(String userRole){
        return userRepository.getUserListsByUserRole(userRole);
    }

    public String getEmail(String username){
        return userRepository.getEmailByUsername(username);
    }

    public List<String> getEmailListByUserRoles(List<String> userRoles){
        return userRepository.getEmailListByUserRoles(userRoles);
    }
}