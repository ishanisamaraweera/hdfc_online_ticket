package com.example.otrs.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsDTO {
    private String password;
    private String displayName;
    private String userRole;
    private String location;
    private String branchDivision;

    public UserDetailsDTO(String password, String displayName, String userRole, String location, String branchDivision) {
        this.password = password;
        this.displayName = displayName;
        this.userRole = userRole;
        this.location = location;
        this.branchDivision = branchDivision;
    }
}
