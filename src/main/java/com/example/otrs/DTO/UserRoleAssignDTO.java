package com.example.otrs.DTO;


import lombok.Data;

import java.util.List;

@Data
public class UserRoleAssignDTO {
    private String userId;
    private List<String> userRoleId;
}