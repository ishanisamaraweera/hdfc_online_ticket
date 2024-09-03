package com.example.otrs.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String reportedDateTime;
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
    private String agentResponseDateTime;
    private String resolvedDateTime;
    private String lastUpdatedUser;
    private String lastUpdatedDateTime;
    private String completedPercentage;
    private String agentComment;
    private String contactNo;
    private String resolutionPeriod;
}