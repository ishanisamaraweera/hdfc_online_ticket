package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*

@author ishani.s
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserRoleAssignId implements Serializable {
    @Column(name = "user_id", length = 45)
    private String userId;

    @Column(name = "user_role_id", length = 45)
    private String userRoleId;
}
