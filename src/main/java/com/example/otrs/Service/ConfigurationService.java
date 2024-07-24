package com.example.otrs.Service;

import com.example.otrs.Entity.EmergencyLevel;
import com.example.otrs.Entity.IssueCategory;
import com.example.otrs.Entity.IssueType;
import com.example.otrs.Entity.Status;
import com.example.otrs.Repository.EmergencyLevelRepository;
import com.example.otrs.Repository.IssueCategoryRepository;
import com.example.otrs.Repository.IssueTypeRepository;
import com.example.otrs.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    EmergencyLevelRepository emergencyLevelRepository;
    @Autowired
    IssueTypeRepository issueTypeRepository;
    @Autowired
    IssueCategoryRepository issueCategoryRepository;
    public List<Status> getStatues() {
        return statusRepository.findAll();
    }

    public List<EmergencyLevel> getEmergencyLevels() {
        return emergencyLevelRepository.findAll();
    }

    public List<IssueType> getIssueTypes() {
        return issueTypeRepository.findAll();
    }

    public List<IssueCategory> getIssueCategories() {
        return issueCategoryRepository.findAll();
    }

    public List<IssueCategory> getIssueCategoriesByIssueType(Integer issueType) {
        return issueCategoryRepository.getIssueCategoriesByIssueType(issueType);
    }
}
