package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Table(name = "issue_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueType {
    @Id
    @Column(name = "issue_type_id")
    private Integer issueTypeId;
    @Column(name = "issue_type_des")
    private String issueTypeDes;
}

