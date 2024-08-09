package com.example.otrs.DTO;

import lombok.Data;

import java.util.List;

/*

@author ishani.s
 */
@Data
public class UserFunctionAssignDTO {
    private String userRole;
    private List<String> functions;
}
