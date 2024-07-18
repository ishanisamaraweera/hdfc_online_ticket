package com.example.otrs.Controller;

import com.example.otrs.Entity.IssueCategory;
import com.example.otrs.Entity.Ticket;
import com.example.otrs.Service.IssueCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IssueCategoryController {
    @Autowired
    IssueCategoryService issueCategoryService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getIssueCategories")
    public List<IssueCategory> getIssueCategories() {
        return issueCategoryService.getIssueCategories();
    }

    @GetMapping("/getIssueCategoriesByIssueType/{issueType}")
    public List<IssueCategory> getIssueCategoriesByIssueType(@PathVariable Integer issueType) {
        return issueCategoryService.getIssueCategoriesByIssueType(issueType);
    }
}
