package com.example.otrs.DTO;

import lombok.Data;

import java.util.List;

/*

@author ishani.s
 */
@Data
public class UserDTO {
    private String username;
    private String displayName;
    private String designation;
    private String dob;
    private String epf;
    private String location;
    private String branchDivision;
    private String addedBy;
    private String addedDateTime;
    private String lastUpdatedUser;
    private String lastUpdatedDateTime;
    private Integer status;
    private List<String> userRoles;
    private String password;

    public UserDTO(String username, String displayName, String designation, String dob, String epf, String location, String branchDivision, String addedBy, String addedDateTime, String lastUpdatedUser, String lastUpdatedDateTime, Integer status, List<String> userRoles, String password) {
        this.username = username;
        this.displayName = displayName;
        this.designation = designation;
        this.dob = dob;
        this.epf = epf;
        this.location = location;
        this.branchDivision = branchDivision;
        this.addedBy = addedBy;
        this.addedDateTime = addedDateTime;
        this.lastUpdatedUser = lastUpdatedUser;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
        this.status = status;
        this.userRoles = userRoles;
        this.password = password;
    }
}