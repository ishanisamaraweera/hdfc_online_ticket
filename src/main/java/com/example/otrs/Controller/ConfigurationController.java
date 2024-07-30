package com.example.otrs.Controller;

import com.example.otrs.DTO.BranchDivisionDTO;
import com.example.otrs.DTO.StatusDTO;
import com.example.otrs.Entity.*;
import com.example.otrs.Service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConfigurationController {
    @Autowired
    ConfigurationService configurationService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getStatuses")
    public List<Status> getStatuses() {
        return configurationService.getStatues();
    }

    @GetMapping("/getStatuses/{module}")
    public List<StatusDTO> getStatuesByModule(@PathVariable String module) {
        return configurationService.getStatuesByModule(module);
    }

    @GetMapping("/getEmergencyLevels")
    public List<EmergencyLevel> getEmergencyLevels() {
        return configurationService.getEmergencyLevels();
    }

    @GetMapping("/getIssueTypes")
    public List<IssueType> getIssueTypes() {
        return configurationService.getIssueTypes();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getIssueCategories")
    public List<IssueCategory> getIssueCategories() {
        return configurationService.getIssueCategories();
    }

    @GetMapping("/getIssueCategoriesByIssueType/{issueType}")
    public List<IssueCategory> getIssueCategoriesByIssueType(@PathVariable Integer issueType) {
        return configurationService.getIssueCategoriesByIssueType(issueType);
    }

    @GetMapping("/getUserRoles")
    public List<UserRole> getUserRoles() {
        return configurationService.getUserRoles();
    }

    @GetMapping("/getLocations")
    public List<Location> getLocations() {
        return configurationService.getLocations();
    }

    @GetMapping("/getBranchDivisionByLocation/{location}")
    public List<BranchDivisionDTO> getBranchDivisionByLocation(@PathVariable String location) {
        return configurationService.getBranchDivisionByLocation(location);
    }
}
