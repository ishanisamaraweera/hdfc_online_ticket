package com.example.otrs.Controller;

import com.example.otrs.DTO.IssueCategoryDTO;
import com.example.otrs.Entity.IssueCategory;
import com.example.otrs.Entity.UserFunction;
import com.example.otrs.Service.IssueCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 @author ishani.s
 */
@RestController
public class IssueCategoryController {
    @Autowired
    IssueCategoryService issueCategoryService;

    //For table
    @GetMapping("/getAllIssueCategories")
    public List<IssueCategoryDTO> getAllIssueCategories (){
        return issueCategoryService.getAllIssueCategories();
    }

    @GetMapping("/getIssueCategoryDetailsById/{issueCategoryId}")
    public Optional<IssueCategory> getIssueCategoryDetailsById(@PathVariable Integer issueCategoryId){
        return issueCategoryService.getIssueCategoryDetailsById(issueCategoryId);
    }

    @PostMapping("/addIssueCategory")
    public IssueCategory addIssueCategory(@RequestBody IssueCategory issueCategory) throws Exception{
        return issueCategoryService.addIssueCategory(issueCategory);
    }

    @PutMapping("/updateIssueCategory")
    public IssueCategory updateIssueCategory(@RequestBody IssueCategory issueCategory) throws Exception{
        return issueCategoryService.updateIssueCategory(issueCategory);
    }

    @PutMapping("/deleteIssueCategory/{issueCategoryId}")
    public void deleteIssueCategory(@PathVariable Integer issueCategoryId) throws Exception{
        issueCategoryService.deleteIssueCategory(issueCategoryId);
    }
}
