package com.example.otrs.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 @author ishani.s
 */
@Entity
@Data
@Table(name = "user_role_function")
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleFunctionAssign {
    @EmbeddedId
    private UserRoleFunctionAssignId id;
}
