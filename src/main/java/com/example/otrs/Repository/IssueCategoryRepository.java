package com.example.otrs.Repository;

import com.example.otrs.Entity.IssueCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueCategoryRepository extends JpaRepository<IssueCategory, Integer> {
    @Query("SELECT ic FROM IssueCategory ic WHERE ic.issueType = :issueType")
    List<IssueCategory> getIssueCategoriesByIssueType(@Param("issueType") Integer issueType);

}
