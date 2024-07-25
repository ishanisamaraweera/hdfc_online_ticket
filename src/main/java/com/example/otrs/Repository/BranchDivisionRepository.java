package com.example.otrs.Repository;

import com.example.otrs.Entity.BranchDivision;
import com.example.otrs.Entity.IssueCategory;
import com.example.otrs.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchDivisionRepository extends JpaRepository<BranchDivision, String> {

    @Query("SELECT bd FROM BranchDivision bd WHERE bd.location = :location")
    List<BranchDivision> getBranchDivisionByLocation(@Param("location") String location);
}
