package com.example.otrs.Repository;

import com.example.otrs.DTO.IssueCategoryDTO;
import com.example.otrs.Entity.IssueCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*

@author ishani.s
 */
@Repository
public interface IssueCategoryRepository extends JpaRepository<IssueCategory, Integer> {
    @Query("SELECT ic FROM IssueCategory ic WHERE ic.issueType = :issueType")
    List<IssueCategory> getIssueCategoriesByIssueType(@Param("issueType") Integer issueType);

    @Query("SELECT new com.example.otrs.DTO.IssueCategoryDTO(" +
            "i.issueCategoryId, " +
            "i.issueCategoryDes, " +
            "it.issueTypeDes as issueType, " +
            "u1.displayName as createdUser, " +
            "i.createdDateTime, " +
            "u2.displayName as lastUpdatedUser, " +
            "i.lastUpdatedDateTime, " +
            "s.statusDes as status) FROM IssueCategory i " +
            "LEFT JOIN IssueType it ON i.issueType = it.issueTypeId " +
            "LEFT JOIN User u1 ON i.createdUser = u1.username " +
            "LEFT JOIN User u2 ON i.createdUser = u2.username " +
            "LEFT JOIN Status s ON i.status = s.statusId ")
    List<Object[]> getAllIssueCategories();

}
