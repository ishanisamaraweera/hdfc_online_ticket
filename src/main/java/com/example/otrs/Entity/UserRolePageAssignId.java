package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 @author ishani.s
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserRolePageAssignId implements Serializable {
    @Column(name = "user_role_id", length = 45)
    private String userRoleId;

    @Column(name = "page_id", length = 45)
    private String pageId;
}