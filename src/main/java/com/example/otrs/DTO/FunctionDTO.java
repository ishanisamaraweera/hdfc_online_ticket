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
public class FunctionDTO {
    private String userFunctionId;
    private String userFunctionDes;
    private String createdUser;
    private String createdDateTime;
    private String lastUpdatedUser;
    private String lastUpdatedDateTime;
    private String status;

    public FunctionDTO(String userFunctionId, String userFunctionDes, String createdUser, String createdDateTime, String lastUpdatedUser, String lastUpdatedDateTime, String status) {
        this.userFunctionId = userFunctionId;
        this.userFunctionDes = userFunctionDes;
        this.createdUser = createdUser;
        this.createdDateTime = createdDateTime;
        this.lastUpdatedUser = lastUpdatedUser;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
        this.status = status;
    }
}
