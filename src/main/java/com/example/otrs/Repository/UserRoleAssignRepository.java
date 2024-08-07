package com.example.otrs.Repository;

import com.example.otrs.Entity.UserRoleAssign;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*

@author ishani.s
 */
@Repository
public interface UserRoleAssignRepository extends JpaRepository<UserRoleAssign, String> {
    @Modifying
    @Transactional
    @Query("DELETE FROM UserRoleAssign u WHERE u.id.userId = :userId")
    void deleteExistingUserRoles(String userId);

}
