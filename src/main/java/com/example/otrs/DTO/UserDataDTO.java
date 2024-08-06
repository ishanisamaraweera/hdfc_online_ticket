package com.example.otrs.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDataDTO {
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
    private String status;
    private List<String> userRoles;

    public UserDataDTO(String username, String displayName, String designation, String dob, String epf,
                       String location, String branchDivision, String addedBy, String addedDateTime, String lastUpdatedUser,
                       String lastUpdatedDateTime, String status, List<String> userRoles) {
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
    }
}