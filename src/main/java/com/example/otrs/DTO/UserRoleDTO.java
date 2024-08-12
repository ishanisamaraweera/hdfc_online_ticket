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
public class UserRoleDTO {
    private String userRoleId;
    private String userRoleDes;
    private String createdUser;
    private String createdDateTime;
    private String lastUpdatedUser;
    private String lastUpdatedDateTime;
    private String status;

    public UserRoleDTO(String userRoleId, String userRoleDes, String createdUser, String createdDateTime, String lastUpdatedUser, String lastUpdatedDateTime, String status) {
        this.userRoleId = userRoleId;
        this.userRoleDes = userRoleDes;
        this.createdUser = createdUser;
        this.createdDateTime = createdDateTime;
        this.lastUpdatedUser = lastUpdatedUser;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
        this.status = status;
    }
}
