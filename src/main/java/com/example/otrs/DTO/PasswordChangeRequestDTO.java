package com.example.otrs.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PasswordChangeRequestDTO {
    private String username;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}