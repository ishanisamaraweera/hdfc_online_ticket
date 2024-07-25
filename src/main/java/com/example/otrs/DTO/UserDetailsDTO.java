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
    private String locationDes;
    private String branchDivisionDes;

    public UserDetailsDTO(String password, String displayName, String locationDes, String branchDivisionDes) {
        this.password = password;
        this.displayName = displayName;
        this.locationDes = locationDes;
        this.branchDivisionDes = branchDivisionDes;
    }
}
