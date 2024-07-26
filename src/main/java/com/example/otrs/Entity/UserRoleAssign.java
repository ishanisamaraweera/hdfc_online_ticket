package com.example.otrs.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name = "user_role_assign")
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleAssign {
    @EmbeddedId
    private UserRoleAssignId id;
}

//public class UserRoleAssign {
//    @Id
//    @Column(name = "user_id", length = 45)
//    private String userId;
//
//    @Id
//    @Column(name = "user_role_id", length = 45)
//    private String userRoleId;
//}
