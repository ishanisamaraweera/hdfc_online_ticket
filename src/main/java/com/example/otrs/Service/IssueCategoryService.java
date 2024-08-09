package com.example.otrs.Service;

import com.example.otrs.DTO.IssueCategoryDTO;
import com.example.otrs.Repository.IssueCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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
}