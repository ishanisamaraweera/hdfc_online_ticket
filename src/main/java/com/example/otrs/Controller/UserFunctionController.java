package com.example.otrs.Controller;

import com.example.otrs.DTO.FunctionDTO;
import com.example.otrs.DTO.UserFunctionAssignDTO;
import com.example.otrs.DTO.UserFunctionDTO;
import com.example.otrs.Entity.UserFunction;
import com.example.otrs.Service.UserFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 @author ishani.s
 */
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

    @GetMapping("/getAllUserFunctions")
    public List<FunctionDTO> getAllUserFunctions (){
        return userFunctionService.getAllUserFunctions();
    }

    @GetMapping("/getFunctionDetailsByFunctionId/{userFunctionId}")
    public UserFunction getFunctionDetailsByFunctionId(@PathVariable String userFunctionId) {
        return userFunctionService.getFunctionDetailsByFunctionId(userFunctionId);
    }

    //Update all function details
    @PutMapping("/updateFunction")
    public UserFunction updateFunction(@RequestBody UserFunction userFunction) throws Exception{
        return userFunctionService.updateFunction(userFunction);
    }

    @PutMapping("/deleteFunction/{userFunctionId}")
    public void deleteFunction(@PathVariable String userFunctionId) throws Exception{
        userFunctionService.deleteFunction(userFunctionId);
    }
}
