package com.example.otrs.Repository;

import com.example.otrs.Entity.UserFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFunctionRepository extends JpaRepository<UserFunction, String> {
}
