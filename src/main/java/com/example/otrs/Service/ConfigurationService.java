package com.example.otrs.Service;

import com.example.otrs.Entity.Status;
import com.example.otrs.Repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {
    @Autowired
    ConfigurationRepository configurationRepository;

    public List<Status> getStatues() {
        return configurationRepository.findAll();
    }
}
