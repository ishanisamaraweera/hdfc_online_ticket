package com.example.otrs.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 *
 @author ishani.s
 */
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
