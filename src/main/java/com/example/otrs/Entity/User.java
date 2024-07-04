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
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "display_name")
    private String displayName;
    @Column(name = "password")
    private String password;
    @Column(name = "location")
    private String location;
    @Column(name = "branch_division")
    private String branchDivision;
    @Column(name = "designation")
    private String designation;
    @Column(name = "user_role")
    private String userRole;
    @Column(name = "added_by")
    private String addedBy;
    @Column(name = "added_date_time")
    private String addedDateTime;
    @Column(name = "last_updated_user")
    private String lastUpdatedUser;
    @Column(name = "last_updated_date_time")
    private String lastUpdatedDateTime;
}
