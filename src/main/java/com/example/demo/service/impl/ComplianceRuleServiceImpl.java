package com.example.demo.service.impl;

import com.example.demo.ComplianceRule;
import com.example.demo.repository.ComplianceRuleRepository;
import com.example.demo.service.ComplianceRuleService;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceRuleServiceImpl implements ComplianceRuleService {

   
    private final ComplianceRuleRepository repository;
    public ComplianceRuleServiceImpl (ComplianceRuleRepository repository)
    {
        this.obj=obj;
    }

    @Override
    public ComplianceRule createRule(ComplianceRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<ComplianceRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public ComplianceRule getRule(Long id) {
        return repository.findById(id).orElse(null);
    }
}