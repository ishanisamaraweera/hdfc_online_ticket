package com.example.otrs.Controller;

import com.example.otrs.Entity.IssueType;
import com.example.otrs.Service.IssueTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IssueTypeController {
    @Autowired
    IssueTypeService issueTypeService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getIssueTypes")
    public List<IssueType> getIssueTypes() {
        return issueTypeService.getIssueTypes();
    }
}
