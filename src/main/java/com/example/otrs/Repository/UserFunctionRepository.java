package com.example.otrs.Repository;

import com.example.otrs.Entity.UserFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 @author ishani.s
 */
@Repository
public interface UserFunctionRepository extends JpaRepository<UserFunction, String> {
    @Query("SELECT f FROM UserFunction f WHERE status = 7")
    List<UserFunction> getUserFunctions();

    @Query("SELECT DISTINCT urf.userFunctionId, " +
            "urf.userFunctionDes, " +
            "u1.displayName as createdUser," +
            "urf.createdDateTime," +
            "u2.displayName as lastUpdatedUser," +
            "urf.lastUpdatedDateTime, " +
            "s.statusDes as status " +
            "FROM UserFunction urf " +
            "LEFT JOIN Status s ON  urf.status = s.statusId " +
            "LEFT JOIN User u1 ON urf.createdUser = u1.username " +
            "LEFT JOIN User u2 ON urf.lastUpdatedUser = u2.username " +
            "WHERE urf.status <> 6")
    List<Object[]> getAllUserFunctions();

    @Query("SELECT f FROM UserFunction f WHERE userFunctionId = :userFunctionId")
    UserFunction getFunctionDetailsByFunctionId(String userFunctionId);
}
