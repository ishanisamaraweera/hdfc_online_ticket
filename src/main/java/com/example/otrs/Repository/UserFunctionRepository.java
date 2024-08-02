package com.example.otrs.Repository;

import com.example.otrs.Entity.UserFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFunctionRepository extends JpaRepository<UserFunction, String> {
    @Query("SELECT f FROM UserFunction f WHERE status = 7")
    List<UserFunction> getUserFunctions();
}
