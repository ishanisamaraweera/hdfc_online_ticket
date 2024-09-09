package com.example.otrs.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 *
 @author ishani.s
 */
public class UserDataDTO {
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
    private String status;
    private List<String> userRoles;
    private String password;
    private String locationId;
    private String locationDes;
    private String branchDivisionId;
    private String branchDivisionDes;
}