package com.example.otrs.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 @author ishani.s
 */
@Entity
@Data
@Table(name = "user_role_page")
@NoArgsConstructor
@AllArgsConstructor
public class UserRolePageAssign {
    @EmbeddedId
    private UserRolePageAssignId id;
}
