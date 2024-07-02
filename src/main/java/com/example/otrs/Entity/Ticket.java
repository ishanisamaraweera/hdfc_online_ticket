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

    public Long getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Long ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReportedDateTime() {
        return reportedDateTime;
    }

    public void setReportedDateTime(String reportedDateTime) {
        this.reportedDateTime = reportedDateTime;
    }

    public String getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel(String emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBranchOrDivision() {
        return branchOrDivision;
    }

    public void setBranchOrDivision(String branchOrDivision) {
        this.branchOrDivision = branchOrDivision;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getIssueCategory() {
        return issueCategory;
    }

    public void setIssueCategory(String issueCategory) {
        this.issueCategory = issueCategory;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getIsWorkingPc() {
        return isWorkingPc;
    }

    public void setIsWorkingPc(String isWorkingPc) {
        this.isWorkingPc = isWorkingPc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIssueDesAndRemarks() {
        return issueDesAndRemarks;
    }

    public void setIssueDesAndRemarks(String issueDesAndRemarks) {
        this.issueDesAndRemarks = issueDesAndRemarks;
    }

    public String getAgentResponseDateTime() {
        return agentResponseDateTime;
    }

    public void setAgentResponseDateTime(String agentResponseDateTime) {
        this.agentResponseDateTime = agentResponseDateTime;
    }

    public String getResolvedDateTime() {
        return resolvedDateTime;
    }

    public void setResolvedDateTime(String resolvedDateTime) {
        this.resolvedDateTime = resolvedDateTime;
    }

    public String getResolutionPeriod() {
        return resolutionPeriod;
    }

    public void setResolutionPeriod(String resolutionPeriod) {
        this.resolutionPeriod = resolutionPeriod;
    }

    public String getAgentComments() {
        return agentComments;
    }

    public void setAgentComments(String agentComments) {
        this.agentComments = agentComments;
    }

    public String getLastUpdatedUser() {
        return lastUpdatedUser;
    }

    public void setLastUpdatedUser(String lastUpdatedUser) {
        this.lastUpdatedUser = lastUpdatedUser;
    }

    public String getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    public void setLastUpdatedDateTime(String lastUpdatedDateTime) {
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    @Column(name = "last_updated_date_time")
    private String lastUpdatedDateTime;
}

