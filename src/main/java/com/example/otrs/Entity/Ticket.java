package com.example.otrs.Entity;

import jakarta.persistence.*;
import lombok.*;

/*

@author ishani.s
 */

@Entity
@Data
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @Column(name = "ticket_no")
    private Long ticketNo;
    @Column(name = "sender")
    private String sender;
    @Column(name = "assignee")
    private String assignee;
    @Column(name = "reported_date_time")
    private String reportedDateTime;
    @Column(name = "emergency_level")
    private String emergencyLevel;
    @Column(name = "status")
    private String status;
    @Column(name = "location")
    private String location;
    @Column(name = "branch_or_division")
    private String branchOrDivision;
    @Column(name = "issue_type")
    private String issueType;
    @Column(name = "issue_category")
    private String issueCategory;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "serial_no")
    private String serialNo;
    @Column(name = "is_working_pc")
    private String isWorkingPc;
    @Column(name = "ip")
    private String ip;
    @Column(name = "issue_des_and_remarks")
    private String issueDesAndRemarks;
    @Column(name = "agent_response_date_time")
    private String agentResponseDateTime;
    @Column(name = "resolved_date_time")
    private String resolvedDateTime;
    @Column(name = "resolution_period")
    private String resolutionPeriod;
    @Column(name = "agent_comments")
    private String agentComments;
    @Column(name = "last_updated_user")
    private String lastUpdatedUser;
    @Column(name = "last_updated_date_time")
    private String lastUpdatedDateTime;
}

