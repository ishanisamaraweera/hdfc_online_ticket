package com.example.otrs.Controller;

import com.example.otrs.DTO.IssueCategoryDTO;
import com.example.otrs.Service.IssueCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IssueCategoryController {
    @Autowired
    IssueCategoryService issueCategoryService;

    @GetMapping("/getAllIssueCategories")
    public List<IssueCategoryDTO> getAllIssueCategories (){
        return issueCategoryService.getAllIssueCategories();
    }
}
