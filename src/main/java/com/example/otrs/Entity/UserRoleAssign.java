package com.example.otrs.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*

@author ishani.s
 */
@Entity
@Data
@Table(name = "user_role_assign")
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleAssign {
    @EmbeddedId
    private UserRoleAssignId id;
}
