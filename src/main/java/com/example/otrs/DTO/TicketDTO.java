package com.example.otrs.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 *
 @author ishani.s
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private String ticketId;
    private String sender;
    private String agent;
    private LocalDateTime reportedDateTime;
    private String emergencyLevel;
    private String status;
    private String location;
    private String branchDivision;
    private String issueType;
    private String issueCategory;
    private String serialNo;
    private String isWorkingPc;
    private String ip;
    private String issueDesAndRemarks;
    private LocalDateTime agentResponseDateTime;
    private LocalDateTime resolvedDateTime;
    private String lastUpdatedUser;
    private LocalDateTime lastUpdatedDateTime;
    private Integer completedPercentage;
    private String agentComment;
    private String contactNo;
    private String resolutionPeriod;
}