package com.example.otrs.Repository;

import com.example.otrs.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/*

@author ishani.s
 */
public interface TicketRepository extends JpaRepository<Ticket, String> {
    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.sender = :username AND t.status = 'In Progress'")
    long getActiveTicketCount(@Param("username") String username);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.sender = :username AND t.status = 'Completed'")
    long getCompletedTicketCount(@Param("username") String username);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.sender = :username AND t.status = 'Closed'")
    long getClosedTicketCount(@Param("username") String username);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.sender = :username")
    long getTotalTicketCount(@Param("username") String username);

    @Query("SELECT t FROM Ticket t WHERE t.status != 'Deleted'")
    List<Ticket> getAllTicketDetails();
}

