package com.example.otrs.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
*
@author ishani.s
 */
@Entity
@Data
@Table(name = "issue_category")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_category_id")
    private Integer issueCategoryId;
    @Column(name = "issue_type")
    private Integer issueType;
    @Column(name = "issue_category_des")
    private String issueCategoryDes;
    @Column(name = "created_user")
    private String createdUser;
    @Column(name = "created_date_time")
    private String createdDateTime;
    @Column(name = "last_updated_user")
    private String lastUpdatedUser;
    @Column(name = "last_updated_date_time")
    private String lastUpdatedDateTime;
    @Column(name = "status")
    private Integer status;
}