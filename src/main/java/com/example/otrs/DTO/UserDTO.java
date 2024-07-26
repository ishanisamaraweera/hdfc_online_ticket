package com.example.otrs.DTO;

import lombok.Data;

import java.util.List;

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
}