package com.example.otrs.Repository;

import com.example.otrs.Entity.Ticket;
import com.example.otrs.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Ticket, String> {
    @Query("SELECT u FROM User U WHERE u.username =  :username")
    User getUserDetails(@Param("username") int username);
}
