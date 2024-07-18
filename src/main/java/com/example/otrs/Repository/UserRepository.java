package com.example.otrs.Repository;

import com.example.otrs.DTO.UserDetailsDTO;
import com.example.otrs.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.username =  :username")
    User getUserDetailsByUsername(@Param("username") String username);

    @Query("SELECT new com.example.otrs.DTO.UserDetailsDTO(u.password, " +
            "u.displayName, " +
            "u.userRole, " +
            "l.locationDes, " +
            "bd.branchDivisionDes) " +
            "FROM User u " +
            "LEFT JOIN Location l ON l.locationId = u.location " +
            "LEFT JOIN BranchDivision bd ON bd.location = u.location WHERE u.username = :username")
    UserDetailsDTO getUserDetailsForTicketByUsername(@Param("username") String username);
}