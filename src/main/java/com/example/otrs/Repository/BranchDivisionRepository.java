package com.example.otrs.Repository;

import com.example.otrs.DTO.BranchDivisionDTO;
import com.example.otrs.Entity.BranchDivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 @author ishani.s
 */
@Repository
public interface BranchDivisionRepository extends JpaRepository<BranchDivision, String> {
    @Query("SELECT new com.example.otrs.DTO.BranchDivisionDTO(bd.branchDivisionId, bd.branchDivisionDes) " +
            "FROM BranchDivision bd WHERE bd.location = :location")
    List<BranchDivisionDTO> getBranchDivisionByLocation(@Param("location") String location);
}
