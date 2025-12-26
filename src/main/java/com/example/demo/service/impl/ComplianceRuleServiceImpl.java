package com.example.demo.service.impl;

import com.example.demo.repository.ComplianceRuleRepository;

public class ComplianceRuleServiceImpl {
    private final ComplianceRuleRepository repo;

    public ComplianceRuleServiceImpl(ComplianceRuleRepository repo) {
        this.repo = repo;
    }
}