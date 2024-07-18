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
    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.sender = :username AND t.status = 1")
    long getNewTicketCount(@Param("username") String username);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.sender = :username AND t.status = 2")
    long getAssignedTicketCount(@Param("username") String username);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.sender = :username AND t.status = 3")
    long getActiveTicketCount(@Param("username") String username);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.sender = :username AND t.status = 4")
    long getCompletedTicketCount(@Param("username") String username);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.sender = :username AND t.status = 5")
    long getClosedTicketCount(@Param("username") String username);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.sender = :username and t.status <> 6")
    long getTotalTicketCount(@Param("username") String username);

    @Query("SELECT t FROM Ticket t WHERE t.status <> 6 ORDER BY t.lastUpdatedDateTime DESC")
    List<Ticket> getAllTicketDetails();

    @Query("SELECT MAX(t.ticketId) FROM Ticket t")
    Integer findMaxTicketNo();

    @Query("SELECT t FROM Ticket t WHERE t.ticketId = :ticketId")
    Ticket getAllDetailsByID(@Param("ticketId") String ticketId);
}

