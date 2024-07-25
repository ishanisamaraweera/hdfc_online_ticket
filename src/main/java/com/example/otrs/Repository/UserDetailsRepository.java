package com.example.otrs.Repository;

import com.example.otrs.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDetailsRepository extends JpaRepository<User, String> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO User (username, password, displayName, " +
            "epf, designation, dob, location, branchDivision, addedBy, addedDateTime, lastUpdatedUser, lastUpdatedDateTime) " +
            "VALUES (:username, :password, :displayName, :epf, :designation, :dob, :location, :branchDivision, :addedBy, " +
            ":addedDateTime, :lastUpdatedUser, :lastUpdatedDateTime)")
    void saveDetails(@Param("username") String username,
                               @Param("password") String password,
                               @Param("displayName") String displayName,
                               @Param("epf") String epf,
                               @Param("designation") String designation,
                               @Param("dob") String dob,
                               @Param("location") String location,
                               @Param("branchDivision") String branchDivision,
                               @Param("addedBy") String addedBy,
                               @Param("addedDateTime") String addedDateTime,
                               @Param("lastUpdatedUser") String lastUpdatedUser,
                               @Param("lastUpdatedDateTime") String lastUpdatedDateTime);
}

