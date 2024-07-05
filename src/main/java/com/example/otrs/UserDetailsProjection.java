package com.example.otrs;

public interface UserDetailsProjection {
    String getPassword();
    String getDisplayName();
    String getUserRole();
    String getLocation();
    String getBranchDivision();
}

