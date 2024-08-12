package com.example.otrs.DTO;


import lombok.Data;

import java.util.List;

/**
 *
 @author ishani.s
 */
@Data
public class UserRoleAssignDTO {
    private String userId;
    private List<String> userRoleId;
}