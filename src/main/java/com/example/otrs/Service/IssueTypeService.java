package com.example.otrs.Service;

import com.example.otrs.Entity.IssueType;
import com.example.otrs.Repository.IssueTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueTypeService {
    @Autowired
    IssueTypeRepository issueTypeRepository;

    public List<IssueType> getIssueTypes() {
        return issueTypeRepository.findAll();
    }
}
