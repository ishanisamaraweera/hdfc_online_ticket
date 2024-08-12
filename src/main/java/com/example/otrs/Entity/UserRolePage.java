package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 @author ishani.s
 */
@Data
@Table(name = "user_role_page")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserRolePage {
    @Id
    @Column(name = "user_role_id", length = 45)
    private String userRoleId;

    @Id
    @Column(name = "page_id", length = 45)
    private String pageId;
}