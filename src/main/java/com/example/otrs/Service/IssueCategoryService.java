package com.example.otrs.Service;

import com.example.otrs.DTO.IssueCategoryDTO;
import com.example.otrs.Entity.IssueCategory;
import com.example.otrs.Repository.IssueCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
*
@author ishani.s
 */
@Service
public class IssueCategoryService {
    @Autowired
    IssueCategoryRepository issueCategoryRepository;

    public List<IssueCategoryDTO> getAllIssueCategories() {
        List<Object[]> results = issueCategoryRepository.getAllIssueCategories();
        List<IssueCategoryDTO> issueCategories = new ArrayList<>();

        for (Object[] result : results) {
            IssueCategoryDTO issueCategory = new IssueCategoryDTO();
            issueCategory.setIssueCategoryId((Integer) result[0]);
            issueCategory.setIssueCategoryDes((String) result[1]);
            issueCategory.setIssueType((String) result[2]);
            issueCategory.setCreatedUser((String) result[3]);
            issueCategory.setCreatedDateTime((String) result[4]);
            issueCategory.setLastUpdatedUser((String) result[5]);
            issueCategory.setLastUpdatedDateTime((String) result[6]);
            issueCategory.setStatus((String) result[7]);
            issueCategories.add(issueCategory);
        }
        return issueCategories;
    }

    public Optional<IssueCategory> getIssueCategoryDetailsById(Integer issueCategoryId){
        return issueCategoryRepository.findById(issueCategoryId);
    }

    public IssueCategory addIssueCategory(IssueCategory issueCategory) {
        int  issueCategoryId = issueCategoryRepository.findMaxIssueCategoryId() + 1;
        issueCategory.setIssueCategoryId(issueCategoryId);
        issueCategory.setCreatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        issueCategory.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return issueCategoryRepository.save(issueCategory);
    }

    public IssueCategory updateIssueCategory(IssueCategory issueCategory) throws Exception {
        IssueCategory updateIssueCategory = issueCategoryRepository.findById(issueCategory.getIssueCategoryId()).orElse(null);

        if (updateIssueCategory == null) {
            throw new Exception("User not found");
        }
        updateIssueCategory.setIssueCategoryDes(issueCategory.getIssueCategoryDes());
        updateIssueCategory.setIssueType(issueCategory.getIssueType());
        updateIssueCategory.setStatus(issueCategory.getStatus());
        updateIssueCategory.setLastUpdatedUser(issueCategory.getLastUpdatedUser());
        updateIssueCategory.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        issueCategoryRepository.save(updateIssueCategory);
        return updateIssueCategory;
    }

    public void deleteIssueCategory(Integer issueCategoryId) throws Exception {
        IssueCategory deleteIssueCategory = issueCategoryRepository.findById(issueCategoryId).orElse(null);

        if (deleteIssueCategory == null) {
            throw new Exception("Issue category not found");
        }
        deleteIssueCategory.setStatus(6);
        deleteIssueCategory.setLastUpdatedDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        issueCategoryRepository.save((deleteIssueCategory));
    }
}