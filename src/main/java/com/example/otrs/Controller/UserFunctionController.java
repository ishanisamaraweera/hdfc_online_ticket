package com.example.otrs.Controller;

import com.example.otrs.DTO.UserFunctionAssignDTO;
import com.example.otrs.DTO.UserFunctionDTO;
import com.example.otrs.Entity.UserFunction;
import com.example.otrs.Service.UserFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserFunctionController {
    @Autowired
    UserFunctionService userFunctionService;

    @PostMapping("/assignFunction")
    public boolean userFunctionAssign (@RequestBody UserFunctionAssignDTO userFunctionAssignDetails){
        return userFunctionService.userFunctionAssign(userFunctionAssignDetails);
    }

    @GetMapping("/getUserRoleFunctions/{userRoleId}")
    public List<UserFunctionDTO> getUserRoleFunctions (@PathVariable String userRoleId){
        return userFunctionService.getUserRoleFunctions(userRoleId);
    }
}
