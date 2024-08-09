package com.example.otrs.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/**
 *
 * @author ishani.s
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

    public IssueCategoryDTO(Integer issueCategoryId, String issueCategoryDes, String issueType, String createdUser, String createdDateTime, String lastUpdatedUser, String lastUpdatedDateTime, String status) {
        this.issueCategoryId = issueCategoryId;
        this.issueCategoryDes = issueCategoryDes;
        this.issueType = issueType;
        this.createdUser = createdUser;
        this.createdDateTime = createdDateTime;
        this.lastUpdatedUser = lastUpdatedUser;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
        this.status = status;
    }
}
