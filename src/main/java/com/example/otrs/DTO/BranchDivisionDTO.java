package com.example.otrs.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BranchDivisionDTO {
    private String branchDivisionId;
    private String branchDivisionDes;

    public BranchDivisionDTO(String branchDivisionId, String branchDivisionDes) {
        this.branchDivisionId = branchDivisionId;
        this.branchDivisionDes = branchDivisionDes;
    }
}

