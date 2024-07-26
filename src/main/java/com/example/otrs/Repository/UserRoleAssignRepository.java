package com.example.otrs.Repository;

import com.example.otrs.Entity.UserRoleAssign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleAssignRepository extends JpaRepository<UserRoleAssign, String>{
}