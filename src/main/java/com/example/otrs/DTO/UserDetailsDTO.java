package com.example.otrs.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 @author ishani.s
 */
@Getter
@Setter
@NoArgsConstructor
public class UserDetailsDTO {
    private String password;
    private String displayName;
    private String locationId;
    private String locationDes;
    private String branchDivisionId;
    private String branchDivisionDes;

    public UserDetailsDTO(String password, String displayName, String locationId, String locationDes, String branchDivisionId, String branchDivisionDes) {
        this.password = password;
        this.displayName = displayName;
        this.locationId = locationId;
        this.locationDes = locationDes;
        this.branchDivisionId = branchDivisionId;
        this.branchDivisionDes = branchDivisionDes;
    }
}
