package com.example.otrs.DTO;

import lombok.*;

/**
 *
 @author ishani.s
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueCategoryDTO {
    private Integer issueCategoryId;
    private String issueCategoryDes;
    private String issueType;
    private String createdUser;
    private String createdDateTime;
    private String lastUpdatedUser;
    private String lastUpdatedDateTime;
    private String status;
}
