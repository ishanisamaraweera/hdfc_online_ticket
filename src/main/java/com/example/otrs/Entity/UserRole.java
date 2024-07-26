package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*

@author ishani.s
 */
@Entity
@Data
@Table(name = "user_role")
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    @Column(name = "user_role_id", length = 45)
    private String userRoleId;
    @Column(name = "user_role_des")
    private String userRoleDes;
}