package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*

@author ishani.s
 */
@Entity
@Data
@Table(name = "branch_division")
@NoArgsConstructor
@AllArgsConstructor
public class BranchDivision {
    @Id
    @Column(name = "branch_or_division_id", length = 45)
    private String branchDivision;
    @Column(name = "branch_division_des")
    private String branchDivisionDes;
    @Column(name = "location", length = 45)
    private String location;
}
