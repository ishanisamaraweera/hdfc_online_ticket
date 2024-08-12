package com.example.otrs.Repository;

import com.example.otrs.DTO.UserRoleDTO;
import com.example.otrs.Entity.User;
import com.example.otrs.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 @author ishani.s
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    @Query("SELECT u FROM UserRole u WHERE status = 7")
    List<UserRole> getActiveUserRoles();

    @Query("SELECT u FROM UserRole u WHERE u.userRoleId =  :userRoleId")
    UserRole getUserDetailsByUserRole(@Param("userRoleId") String userRoleId);

    @Query("SELECT DISTINCT ur.userRoleId, " +
            "ur.userRoleDes, " +
            "u1.displayName as createdUser," +
            "ur.createdDateTime," +
            "u2.displayName as lastUpdatedUser," +
            "ur.lastUpdatedDateTime, " +
            "s.statusDes " +
            "FROM UserRole ur " +
            "LEFT JOIN Status s ON s.statusId = ur.status " +
            "LEFT JOIN User u1 ON u1.username = ur.createdUser " +
            "LEFT JOIN User u2 ON u2.username = ur.lastUpdatedUser " +
            "WHERE ur.status <> 6")
    List<Object[]> getAllUserRoles();
}
