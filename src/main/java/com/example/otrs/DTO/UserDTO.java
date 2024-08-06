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
    private String password;
    private String location;
    private String branchDivision;
    private String designation;
    private String addedBy;
    private String addedDateTime;
    private String lastUpdatedUser;
    private String lastUpdatedDateTime;
    private String dob;
    private String epf;
    private List<String> userRoles;
    private Integer status;
}