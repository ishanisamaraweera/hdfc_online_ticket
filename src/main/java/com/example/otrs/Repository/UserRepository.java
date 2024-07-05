package com.example.otrs.Repository;

import com.example.otrs.DTO.UserDetailsDTO;
import com.example.otrs.Entity.User;
import com.example.otrs.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.username =  :username")
    User getUserDetailsByUsername(@Param("username") String username);

    @Query("SELECT u.password, " +
            "u.displayName, " +
            "u.userRole, " +
            "u.location, " +
            "u.branchDivision " +
            " FROM User u WHERE u.username =  :username")
    UserDetailsDTO getUserDetailsForTicketByUsername(@Param("username") String username);
}