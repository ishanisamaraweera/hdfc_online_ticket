package com.example.otrs.Repository;

import com.example.otrs.Entity.User;
import com.example.otrs.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    @Query("SELECT u FROM UserRole u WHERE status = 7")
    List<UserRole> getActiveUserRoles();

    @Query("SELECT u FROM User u WHERE u.username =  :username")
    User getUserDetailsByUsername(@Param("username") String username);
}
