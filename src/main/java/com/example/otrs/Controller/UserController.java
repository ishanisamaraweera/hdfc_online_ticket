package com.example.otrs.Controller;

import com.example.otrs.DTO.*;
import com.example.otrs.Entity.User;
import com.example.otrs.Entity.UserRole;
import com.example.otrs.Entity.UserFunction;
import com.example.otrs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.UnknownHostException;
import java.util.List;

/**
 *
 @author ishani.s
 */
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

    @GetMapping("/authenticateUser")
    public boolean authenticateUser(@RequestParam String username, @RequestParam String password) {
        LoginDTO loginInfo = new LoginDTO(username, password);
        return userService.authenticateUser(loginInfo);
    }

    @PutMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody PasswordChangeRequestDTO passwordChangeRequest) {
        boolean isChanged = userService.changePassword(passwordChangeRequest.getUsername(),
                passwordChangeRequest.getOldPassword(),
                passwordChangeRequest.getNewPassword(),
                passwordChangeRequest.getConfirmPassword());
        if (isChanged) {
            return ResponseEntity.ok("Password changed successfully!");
        } else {
            return ResponseEntity.status(400).body("Invalid info");
        }
    }

    @GetMapping("/checkInitialLoginStatus/{username}")
    public String checkInitialLoginStatus (@PathVariable String username){
        return userService.checkInitialLoginStatus(username);
    }

    @GetMapping("/getAllUserDetails")
    public List<UserDataDTO> getAllUserDetails(){
        return userService.getAllUserDetails();
    }

    @GetMapping("/getAllUserRoles")
    public List<UserRoleDTO> getAllUserRoles(){
        return userService.getAllUserRoles();
    }

    @GetMapping("/getUserRolesForUsername/{username}")
    public List<String> getUserRolesForUsername(@PathVariable String username){
        return userService.getUserRolesForUsername(username);
    }

    //Update all user details
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) throws Exception{
        return userService.updateUser(user);
    }

    //Update all user role details
    @PutMapping("/updateUserRole")
    public UserRole updateUserRole(@RequestBody UserRole userRole) throws Exception{
        return userService.updateUserRole(userRole);
    }

    @PostMapping("/assignUserRoles/{username}")
    public boolean assignUserRoles (@RequestBody List<String> userRoles, @PathVariable String username){
        return userService.assignUserRoles(username, userRoles);
    }

    @PutMapping("/deleteUser/{username}")
    public void deleteUser(@PathVariable String username) throws Exception{
        userService.deleteUser(username);
    }

    @PutMapping("/deleteUserRole/{userRoleId}")
    public void deleteUserRole(@PathVariable String userRoleId) throws Exception{
        userService.deleteUserRole(userRoleId);
    }

    @GetMapping("/getUserDetailsByUserRole/{userRoleId}")
    public UserRole getUserDetailsByUserRole(@PathVariable String userRoleId){
        return userService.getUserDetailsByUserRole(userRoleId);
    }

    @GetMapping("/getUserListsByUserRole/{userRole}")
    public List<UserNameDTO> getUserListsByUserRole(@PathVariable String userRole){
        return userService.getUserListsByUserRole(userRole);
    }
}
