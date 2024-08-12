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
public class StatusDTO {
    private Integer statusId;
    private String statusDes;

    public StatusDTO(Integer statusId, String statusDes) {
        this.statusId = statusId;
        this.statusDes = statusDes;
    }
}
