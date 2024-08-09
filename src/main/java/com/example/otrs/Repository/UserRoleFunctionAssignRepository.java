package com.example.otrs.Repository;

import com.example.otrs.DTO.UserFunctionDTO;
import com.example.otrs.Entity.UserRoleFunctionAssign;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/*

@author ishani.s
 */
public interface UserRoleFunctionAssignRepository extends JpaRepository<UserRoleFunctionAssign, String> {
    @Query("SELECT new com.example.otrs.DTO.UserFunctionDTO(u.functionId) FROM UserRoleFunction u WHERE u.userRoleId = :userRoleId")
    List<UserFunctionDTO> getUserRoleFunctions(String userRoleId);

    @Modifying
    @Transactional
    @Query("DELETE FROM UserRoleFunction u WHERE u.userRoleId = :userRoleId")
    void deleteExistingUserFunctions(String userRoleId);


}
