package com.example.otrs.Repository;

import com.example.otrs.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Repository interface for Ticket entity.
 *
 * @author ishani.s
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

    @Query("SELECT t.ticketId, " +
            "u1.displayName as sender, " +
            "u2.displayName as agent, " +
            "t.reportedDateTime, " +
            "e.levelDes as emergencyLevel, " +
            "s.statusDes as status, " +
            "it.issueTypeDes as issueType, " +
            "ic.issueCategoryDes as issueCategory, " +
            "t.serialNo, " +
            "t.isWorkingPc, " +
            "t.ip, " +
            "t.issueDesAndRemarks, " +
            "t.agentResponseDateTime, " +
            "t.resolvedDateTime, " +
            "u3.displayName as lastUpdatedUser, " +
            "t.lastUpdatedDateTime, " +
            "t.completedPercentage, " +
            "t.agentComment, " +
            "bd.branchDivisionDes as branchDivision, " +
            "t.contactNo, " +
            "l.locationDes as location, " +
            "t.resolutionPeriod " +
            "FROM Ticket t " +
            "LEFT JOIN User u1 ON u1.username = t.sender " +
            "LEFT JOIN User u2 ON u2.username = t.agent " +
            "LEFT JOIN User u3 ON u3.username = t.lastUpdatedUser " +
            "LEFT JOIN EmergencyLevel e ON e.levelId = t.emergencyLevel " +
            "LEFT JOIN Status s ON s.statusId = t.status " +
            "LEFT JOIN Location l ON l.locationId = t.location " +
            "LEFT JOIN BranchDivision bd ON bd.branchDivisionId = t.branchDivision " +
            "LEFT JOIN IssueType it ON t.issueType = it.issueTypeId " +
            "LEFT JOIN IssueCategory ic ON t.issueCategory = ic.issueCategoryId " +
            "WHERE t.status <> 6 ORDER BY t.lastUpdatedDateTime DESC")
    List<Object[]> getAllTicketDetails();

    @Query("SELECT t.ticketId, " +
            "u1.displayName as sender, " +
            "u2.displayName as agent, " +
            "t.reportedDateTime, " +
            "e.levelDes as emergencyLevel, " +
            "s.statusDes as status, " +
            "it.issueTypeDes as issueType, " +
            "ic.issueCategoryDes as issueCategory, " +
            "t.serialNo, " +
            "t.isWorkingPc, " +
            "t.ip, " +
            "t.issueDesAndRemarks, " +
            "t.agentResponseDateTime, " +
            "t.resolvedDateTime, " +
            "u3.displayName as lastUpdatedUser, " +
            "t.lastUpdatedDateTime, " +
            "t.completedPercentage, " +
            "t.agentComment, " +
            "bd.branchDivisionDes as branchDivision, " +
            "t.contactNo, " +
            "l.locationDes as location, " +
            "t.resolutionPeriod " +
            "FROM Ticket t " +
            "LEFT JOIN User u1 ON u1.username = t.sender " +
            "LEFT JOIN User u2 ON u2.username = t.agent " +
            "LEFT JOIN User u3 ON u3.username = t.lastUpdatedUser " +
            "LEFT JOIN EmergencyLevel e ON e.levelId = t.emergencyLevel " +
            "LEFT JOIN Status s ON s.statusId = t.status " +
            "LEFT JOIN Location l ON l.locationId = t.location " +
            "LEFT JOIN BranchDivision bd ON bd.branchDivisionId = t.branchDivision " +
            "LEFT JOIN IssueType it ON t.issueType = it.issueTypeId " +
            "LEFT JOIN IssueCategory ic ON t.issueCategory = ic.issueCategoryId " +
            "WHERE t.status <> 6 AND (t.sender = :username OR t.agent = :username) ORDER BY t.lastUpdatedDateTime DESC")
    List<Object[]> getAllTicketDetails(String username);

    @Query(value = "SELECT t.ticket_Id FROM Ticket t " +
            "WHERE CAST(SUBSTRING(t.ticket_Id, LENGTH(t.ticket_Id) - 4, 5) AS UNSIGNED) = (" +
            "  SELECT MAX(CAST(SUBSTRING(t2.ticket_Id, LENGTH(t2.ticket_Id) - 4, 5) AS UNSIGNED)) FROM Ticket t2" +
            ")", nativeQuery = true)
    String findMaxTicketId();

    @Query(value = """
            SELECT SUBSTRING(t.ticket_Id, LENGTH(t.ticket_Id) - 4, 5) AS ticketId
            FROM Ticket t
            WHERE CAST(SUBSTRING(t.ticket_Id, LENGTH(t.ticket_Id) - 4, 5) AS UNSIGNED) = (
              SELECT MAX(CAST(SUBSTRING(t2.ticket_Id, LENGTH(t2.ticket_Id) - 4, 5) AS UNSIGNED))
              FROM Ticket t2
            )""", nativeQuery = true)
    String findTicketWithMaxLastFiveDigits();

    @Query("SELECT t.ticketId, " +
            "u1.displayName as sender, " +
            "u2.displayName as agent, " +
            "t.reportedDateTime, " +
            "e.levelDes as emergencyLevel, " +
            "s.statusDes as status, " +
            "it.issueTypeDes as issueType, " +
            "ic.issueCategoryDes as issueCategory, " +
            "t.serialNo, " +
            "t.isWorkingPc, " +
            "t.ip, " +
            "t.issueDesAndRemarks, " +
            "t.agentResponseDateTime, " +
            "t.resolvedDateTime, " +
            "u3.displayName as lastUpdatedUser, " +
            "t.lastUpdatedDateTime, " +
            "t.completedPercentage, " +
            "t.agentComment, " +
            "bd.branchDivisionDes as branchDivision, " +
            "t.contactNo, " +
            "l.locationDes as location, " +
            "t.resolutionPeriod " +
            "FROM Ticket t " +
            "LEFT JOIN User u1 ON u1.username = t.sender " +
            "LEFT JOIN User u2 ON u2.username = t.agent " +
            "LEFT JOIN User u3 ON u3.username = t.lastUpdatedUser " +
            "LEFT JOIN EmergencyLevel e ON e.levelId = t.emergencyLevel " +
            "LEFT JOIN Status s ON s.statusId = t.status " +
            "LEFT JOIN Location l ON l.locationId = t.location " +
            "LEFT JOIN BranchDivision bd ON bd.branchDivisionId = t.branchDivision " +
            "LEFT JOIN IssueType it ON t.issueType = it.issueTypeId " +
            "LEFT JOIN IssueCategory ic ON t.issueCategory = ic.issueCategoryId " +
            "WHERE t.status = :status ORDER BY t.lastUpdatedDateTime DESC")
    List<Object[]> getAllTicketDetailsByStatus(Integer status);
}

