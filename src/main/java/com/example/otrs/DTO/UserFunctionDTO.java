package com.example.otrs.DTO;

import lombok.Data;

@Data
public class UserFunctionDTO {
    private String functionId;

    public UserFunctionDTO(String userFunctionId) {
        this.functionId = userFunctionId;
    }
}
