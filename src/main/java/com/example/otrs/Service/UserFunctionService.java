package com.example.otrs.Service;

import com.example.otrs.DTO.FunctionDTO;
import com.example.otrs.DTO.UserFunctionAssignDTO;
import com.example.otrs.DTO.UserFunctionDTO;
import com.example.otrs.Entity.UserFunction;
import com.example.otrs.Entity.UserRole;
import com.example.otrs.Entity.UserRoleFunctionAssign;
import com.example.otrs.Entity.UserRoleFunctionAssignId;
import com.example.otrs.Repository.UserFunctionRepository;
import com.example.otrs.Repository.UserRoleFunctionAssignRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*

@author ishani.s
 */
@Service
public class UserFunctionService {
    @Autowired
    UserRoleFunctionAssignRepository userFunctionAssignRepository;
    @Autowired
    UserFunctionRepository userFunctionRepository;

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

    public List<UserFunctionDTO> getUserRoleFunctions(String userRoleId) {
        return userFunctionAssignRepository.getUserRoleFunctions(userRoleId);
    }

    public List<FunctionDTO> getAllUserFunctions() {
        List<Object[]> results = userFunctionRepository.getAllUserFunctions();
        List<FunctionDTO> functions = new ArrayList<>();

        for (Object[] result : results) {
            FunctionDTO function = new FunctionDTO();
            function.setUserFunctionId((String) result[0]);
            function.setUserFunctionDes((String) result[1]);
            function.setCreatedUser((String) result[2]);
            function.setCreatedDateTime((String) result[3]);
            function.setLastUpdatedUser((String) result[4]);
            function.setLastUpdatedDateTime((String) result[5]);
            function.setStatus((String) result[6]);
            functions.add(function);
        }
        return functions;
    }

    public UserFunction getFunctionDetailsByFunctionId(String userFunctionId) {
        return userFunctionRepository.getFunctionDetailsByFunctionId(userFunctionId);
    }

    public UserFunction updateFunction(UserFunction userFunction) throws Exception {
        UserFunction updateUserFunction = userFunctionRepository.findById(userFunction.getUserFunctionId()).orElse(null);

        if (updateUserFunction == null) {
            throw new Exception("User not found");
        }
        updateUserFunction.setUserFunctionDes(userFunction.getUserFunctionDes());
        updateUserFunction.setStatus(userFunction.getStatus());
        updateUserFunction.setLastUpdatedUser(userFunction.getLastUpdatedUser());
        updateUserFunction.setLastUpdatedDateTime(LocalDateTime.now().toString());
        userFunctionRepository.save((updateUserFunction));
        return updateUserFunction;
    }

    public void deleteFunction(String userFunctionId) throws Exception {
        UserFunction deleteFunction = userFunctionRepository.findById(userFunctionId).orElse(null);

        if (deleteFunction == null) {
            throw new Exception("Function not found");
        }
        deleteFunction.setStatus(6);
        deleteFunction.setLastUpdatedDateTime(LocalDateTime.now().toString());
        userFunctionRepository.save((deleteFunction));
    }
}
