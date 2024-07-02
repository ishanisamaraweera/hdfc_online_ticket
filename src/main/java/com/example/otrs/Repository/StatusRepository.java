package com.example.otrs.Repository;

//import com.example.otrs.Entity.Status;
import com.example.otrs.Entity.Ticket;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//public interface StatusRepository extends JpaRepository<Status, String> {
//    @Query("SELECT o FROM Order o JOIN o.user u WHERE u.name = :name")
//    List<Order> findOrdersByUserName(@Param("name") String name);
//}
