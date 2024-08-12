package com.example.otrs.DTO;

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
public class TicketDTO {
    private String ticketId;
    private String sender;
    private String assignee;
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
    private String assigneeResponseDateTime;
    private String resolvedDateTime;
    private String lastUpdatedUser;
    private String lastUpdatedDateTime;
    private String completedPercentage;
    private String assigneeComments;
    private String contactNo;
    private String resolutionPeriod;

    public TicketDTO( String ticketId,
                      String sender,
                      String assignee,
                      String reportedDateTime,
                      String emergencyLevel,
                      String status,
                      String location,
                      String branchDivision,
                      String issueType,
                      String issueCategory,
                      String serialNo,
                      String isWorkingPc,
                      String ip,
                      String issueDesAndRemarks,
                      String assigneeResponseDateTime,
                      String resolvedDateTime,
                      String lastUpdatedUser,
                      String lastUpdatedDateTime,
                      String completedPercentage,
                      String assigneeComments,
                      String contactNo,
                      String resolutionPeriod) {
        this.ticketId = ticketId;
        this.sender = sender;
        this.assignee = assignee;
        this.reportedDateTime = reportedDateTime;
        this.emergencyLevel = emergencyLevel;
        this.status = status;
        this.location = location;
        this.branchDivision = branchDivision;
        this.issueType = issueType;
        this.issueCategory = issueCategory;
        this.serialNo = serialNo;
        this.isWorkingPc = isWorkingPc;
        this.ip = ip;
        this.issueDesAndRemarks = issueDesAndRemarks;
        this.assigneeResponseDateTime = assigneeResponseDateTime;
        this.resolvedDateTime = resolvedDateTime;
        this.lastUpdatedUser = lastUpdatedUser;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
        this.completedPercentage = completedPercentage;
        this.assigneeComments = assigneeComments;
        this.contactNo = contactNo;
        this.resolutionPeriod = resolutionPeriod;
    }
}