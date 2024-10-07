package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.time.LocalDateTime;

/**
 *
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
    @Column(name = "ticket_id", length = 20)
    private String ticketId;
    @Column(name = "sender", length = 45)
    private String sender;
    @Column(name = "agent", length = 45)
    private String agent;
    @Column(name = "reported_date_time")
    private LocalDateTime reportedDateTime;
    @Column(name = "emergency_level", length = 20)
    private String emergencyLevel;
    @Column(name = "status")
    private Integer status;
    @Column(name = "location")
    private String location;
    @Column(name = "branch_division")
    private String branchDivision;
    @Column(name = "issue_type")
    private Integer issueType;
    @Column(name = "issue_category")
    private Integer issueCategory;
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
    private LocalDateTime agentResponseDateTime;
    @Column(name = "resolved_date_time")
    private LocalDateTime resolvedDateTime;
    @Column(name = "resolution_period")
    private String resolutionPeriod;
    @Column(name = "agent_comment")
    private String agentComment;
    @Column(name = "last_updated_user", length = 45)
    private String lastUpdatedUser;
    @Column(name = "last_updated_date_time")
    private LocalDateTime lastUpdatedDateTime;
    @Column(name = "completed_percentage")
    private Integer completedPercentage;
    @Column(name = "attachment_id")
    private String attachmentId;
    @Column (name = "file_path")
    private String filePath;
}