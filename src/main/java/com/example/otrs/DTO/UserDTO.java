package com.example.otrs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 @author ishani.s
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String displayName;
    private String designation;
    private String dob;
    private String epf;
    private String email;
    private String location;
    private String branchDivision;
    private String addedBy;
    private String addedDateTime;
    private String lastUpdatedUser;
    private String lastUpdatedDateTime;
    private Integer status;
    private List<String> userRoles;
    private String password;
}