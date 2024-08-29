package com.example.otrs.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignRequestDTO {
    private String assigneeId;
    private String username;
    private String completedPercentage;
}
