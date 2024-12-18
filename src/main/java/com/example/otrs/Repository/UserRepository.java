package com.example.otrs.Repository;

import com.example.otrs.DTO.UserDetailsDTO;
import com.example.otrs.DTO.UserNameDTO;
import com.example.otrs.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 @author ishani.s
 */
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.username =  :username AND u.status = 7")
    User getUserDetailsByUsernameToAuthenticate(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.username =  :username")
    User getUserDetailsByUsername(@Param("username") String username);

    @Query("SELECT u.displayName FROM User u WHERE u.username =  :username")
    String getDisplayNameByUsername(@Param("username") String username);

    @Query("SELECT new com.example.otrs.DTO.UserDetailsDTO(u.password, " +
            "u.displayName, " +
            "u.location as locationId, " +
            "l.locationDes, " +
            "u.branchDivision as branchDivisionId, " +
            "bd.branchDivisionDes) " +
            "FROM User u " +
            "LEFT JOIN Location l ON l.locationId = u.location " +
            "LEFT JOIN BranchDivision bd ON bd.branchDivisionId = u.branchDivision WHERE u.username = :username")
    UserDetailsDTO getUserDetailsForTicketByUsername(@Param("username") String username);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO User (username, password, displayName, " +
            "epf, email, designation, dob, location, branchDivision, addedBy, addedDateTime, lastUpdatedUser, lastUpdatedDateTime) " +
            "VALUES (:username, :password, :displayName, :epf, :email, :designation, :dob, :location, :branchDivision, :addedBy, " +
            ":addedDateTime, :lastUpdatedUser, :lastUpdatedDateTime)")
    void saveDetails(@Param("username") String username,
                     @Param("password") String password,
                     @Param("displayName") String displayName,
                     @Param("epf") String epf,
                     @Param("email") String email,
                     @Param("designation") String designation,
                     @Param("dob") String dob,
                     @Param("location") String location,
                     @Param("branchDivision") String branchDivision,
                     @Param("addedBy") String addedBy,
                     @Param("addedDateTime") String addedDateTime,
                     @Param("lastUpdatedUser") String lastUpdatedUser,
                     @Param("lastUpdatedDateTime") String lastUpdatedDateTime);

    @Query("SELECT u.initialLogin FROM User u WHERE u.username = :username")
    String checkInitialLoginStatus(@Param("username") String username);

    @Query(value = "SELECT DISTINCT u.username, " +
            "u.displayName, " +
            "u.designation, " +
            "u.dob, " +
            "u.epf, " +
            "u.email, " +
            "l.locationDes as location, " +
            "bd.branchDivisionDes as branchDivision, " +
            "u1.displayName as addedBy, " +
            "u.addedDateTime, " +
            "u2.displayName as lastUpdatedUser, " +
            "u.lastUpdatedDateTime, " +
            "s.statusDes as status " +
            "FROM User u " +
            "LEFT JOIN User u1 ON u1.username = u.addedBy " +
            "LEFT JOIN User u2 ON u2.username = u.lastUpdatedUser " +
            "LEFT JOIN Location l ON l.locationId = u.location " +
            "LEFT JOIN BranchDivision bd ON bd.branchDivisionId = u.branchDivision " +
            "LEFT JOIN Status s ON s.statusId = u.status " +
            "WHERE u.status <> 6 ORDER BY u.lastUpdatedDateTime DESC")
    List<Object[]> getAllUserDetails();

    @Query(value = "SELECT u.id.userRoleId " +
            "FROM UserRoleAssign u " +
            "WHERE u.id.userId = :username")
    List<String> getUserRolesForUsername(String username);

    @Query("SELECT DISTINCT new com.example.otrs.DTO.UserNameDTO(u.username, u.displayName) FROM User u " +
            "WHERE u.username IN (SELECT ura.id.userId FROM UserRoleAssign ura where ura.id.userRoleId = :userRole)")
    List<UserNameDTO> getUserListsByUserRole(@Param("userRole") String userRole);

    @Query("SELECT email FROM User WHERE username = :username")
    String getEmailByUsername(@Param("username") String username);

    @Query("SELECT DISTINCT u.email FROM User u LEFT JOIN UserRoleAssign ura on u.username = ura.id.userId " +
            "WHERE ura.id.userRoleId IN (:userRoles)")
    List<String> getEmailListByUserRoles(@Param("userRoles") List<String> userRoles);
}