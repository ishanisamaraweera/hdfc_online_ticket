package com.example.otrs.Service;

import com.example.otrs.DTO.UserFunctionAssignDTO;
import com.example.otrs.DTO.UserFunctionDTO;
import com.example.otrs.Entity.*;
import com.example.otrs.Repository.UserRoleFunctionAssignRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*

@author ishani.s
 */
@Service
public class UserFunctionService {
    @Autowired
    UserRoleFunctionAssignRepository userFunctionAssignRepository;

    @Transactional
    public boolean userFunctionAssign(UserFunctionAssignDTO userRequest) {
        List<String> functions = userRequest.getFunctions();
        userFunctionAssignRepository.deleteExistingUserFunctions(userRequest.getUserRole());

        for (String function : functions) {
            UserRoleFunctionAssignId id = new UserRoleFunctionAssignId(userRequest.getUserRole(), function);
            UserRoleFunctionAssign userRoleFunctionAssign = new UserRoleFunctionAssign(id);
            userFunctionAssignRepository.save(userRoleFunctionAssign);
        }
        return true;
    }

    public List<UserFunctionDTO> getUserRoleFunctions(String userRoleId){
        return userFunctionAssignRepository.getUserRoleFunctions(userRoleId);
    }
}
