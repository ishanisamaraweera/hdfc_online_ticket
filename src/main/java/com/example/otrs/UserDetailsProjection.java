package com.example.otrs;

/*

@author ishani.s
 */
public interface UserDetailsProjection {
    String getPassword();
    String getDisplayName();
    String getUserRole();
    String getLocation();
    String getBranchOrDivision();
}

