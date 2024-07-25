package com.example.otrs.Service;

import com.example.otrs.Entity.*;
import com.example.otrs.Repository.*;
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
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    BranchDivisionRepository branchDivisionRepository;

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

    public List<UserRole> getUserRoles() {
        return userRoleRepository.findAll();
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public List<BranchDivision> getBranchDivisionByLocation(String location) {
        return branchDivisionRepository.getBranchDivisionByLocation(location);
    }


}
