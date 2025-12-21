package com.example.demo.service;
import com.example.demo.service.ComplianceRule;
import java.util.List;

public interface ComplianceRuleService
{
    ComplianceRule createRule(ComplianceRule rule);
    List<ComplianceRule> getAllRules();
    ComplianceRule getRule(Long id);
}