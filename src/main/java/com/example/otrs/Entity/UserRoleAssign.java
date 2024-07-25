package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user_role_assign")
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleAssign {
    @Id
    @Column(name = "user_id", length = 45)
    private String userRoleId;
    @Column(name = "user_role_id")
    private String userRoleDes;
}
