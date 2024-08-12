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
@Entity
@Data
@Table(name = "user_function")
@NoArgsConstructor
@AllArgsConstructor
public class UserFunction {
    @Id
    @Column(name = "user_function_id", length = 45)
    private String userFunctionId;
    @Column(name = "user_function_des")
    private String userFunctionDes;
    @Column(name = "status")
    private Integer status;
    @Column(name = "created_user", length = 45)
    private String createdUser;
    @Column(name = "created_date_time")
    private String createdDateTime;
    @Column(name = "last_updated_user", length = 45)
    private String lastUpdatedUser;
    @Column(name = "last_updated_date_time")
    private String lastUpdatedDateTime;
}