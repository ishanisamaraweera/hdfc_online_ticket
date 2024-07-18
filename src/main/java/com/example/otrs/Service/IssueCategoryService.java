package com.example.otrs.Service;

import com.example.otrs.Entity.IssueCategory;
import com.example.otrs.Repository.IssueCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueCategoryService {
    @Autowired
    IssueCategoryRepository issueCategoryRepository;

    public List<IssueCategory> getIssueCategories() {
        return issueCategoryRepository.findAll();
    }

    public List<IssueCategory> getIssueCategoriesByIssueType(Integer issueType) {
        return issueCategoryRepository.getIssueCategoriesByIssueType(issueType);
    }
}
