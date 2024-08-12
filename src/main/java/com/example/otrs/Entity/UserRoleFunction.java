package com.example.otrs.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 @author ishani.s
 */
@Data
@Table(name = "user_role_function")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserRoleFunction {
    @Id
    @Column(name = "user_role_id", length = 45)
    private String userRoleId;

    @Id
    @Column(name = "function_id", length = 45)
    private String functionId;
}