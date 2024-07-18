package com.example.otrs.Entity;

import jakarta.persistence.*;
import lombok.*;

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
}