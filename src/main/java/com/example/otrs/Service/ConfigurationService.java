package com.example.otrs.Service;

import com.example.otrs.DTO.BranchDivisionDTO;
import com.example.otrs.DTO.StatusDTO;
import com.example.otrs.Entity.*;
import com.example.otrs.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<StatusDTO> getStatuesByModule(String module) {
        List<Object[]> results = statusRepository.getStatuesByModule(module);
        return results.stream()
                .map(result -> new StatusDTO((Integer) result[0], (String) result[1]))
                .collect(Collectors.toList());
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
        return userRoleRepository.getActiveUserRoles();
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public List<BranchDivisionDTO> getBranchDivisionByLocation(String location) {
        return branchDivisionRepository.getBranchDivisionByLocation(location);
    }


}
