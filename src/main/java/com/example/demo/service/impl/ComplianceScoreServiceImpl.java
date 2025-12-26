package com.example.demo.service.impl;

import com.example.demo.model.ComplianceScore;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComplianceScoreServiceImpl {

    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;
    private final VendorDocumentRepository vendorDocumentRepository;
    private final ComplianceScoreRepository complianceScoreRepository;

    public ComplianceScoreServiceImpl(
            VendorRepository vendorRepository,
            DocumentTypeRepository documentTypeRepository,
            VendorDocumentRepository vendorDocumentRepository,
            ComplianceScoreRepository complianceScoreRepository
    ) {
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.complianceScoreRepository = complianceScoreRepository;
    }

    public ComplianceScore calculateCompliance(Long vendorId) {
        return evaluateVendor(vendorId);
    }

    public ComplianceScore evaluateVendor(Long vendorId) {
        ComplianceScore score = new ComplianceScore();
        return complianceScoreRepository.save(score);
    }

    public ComplianceScore getScore(Long vendorId) {
        Optional<ComplianceScore> existing = complianceScoreRepository.findById(vendorId);
        return existing.orElse(null);
    }
}