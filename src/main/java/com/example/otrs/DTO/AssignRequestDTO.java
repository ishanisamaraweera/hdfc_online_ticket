package com.example.otrs.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 @author ishani.s
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignRequestDTO {
    private String agentId;
    private String username;
    private Integer completedPercentage;
    private String agentComment;
}
