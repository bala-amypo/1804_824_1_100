package com.example.demo.service.impl;

import com.example.demo.model.ComplianceScore;
import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final VendorDocumentRepository vendorDocumentRepository;
    private final VendorRepository vendorRepository;
    private final ComplianceScoreRepository complianceScoreRepository;

    public ComplianceScoreServiceImpl(
            VendorDocumentRepository vendorDocumentRepository,
            VendorRepository vendorRepository,
            ComplianceScoreRepository complianceScoreRepository
    ) {
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.vendorRepository = vendorRepository;
        this.complianceScoreRepository = complianceScoreRepository;
    }

    @Override
    public ComplianceScore evaluateVendor(Long vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        Set<DocumentType> requiredTypes = vendor.getSupportedDocumentTypes()
                .stream()
                .filter(t -> Boolean.TRUE.equals(t.getRequired()))
                .collect(Collectors.toSet());

        if (requiredTypes.isEmpty()) {
            ComplianceScore score = new ComplianceScore();
            score.setVendor(vendor);
            score.setScoreValue(100.0);
            return complianceScoreRepository.save(score);
        }

        List<VendorDocument> documents =
                vendorDocumentRepository.findByVendorId(vendorId);

        long validCount = documents.stream()
                .filter(d -> d.getExpiryDate() == null || d.getExpiryDate().isAfter(LocalDate.now()))
                .map(VendorDocument::getDocumentType)
                .filter(requiredTypes::contains)
                .distinct()
                .count();

        double scoreValue = (validCount * 100.0) / requiredTypes.size();

        ComplianceScore score = new ComplianceScore();
        score.setVendor(vendor);
        score.setScoreValue(scoreValue);

        return complianceScoreRepository.save(score);
    }

    @Override
    public ComplianceScore getScore(Long vendorId) {
        return complianceScoreRepository.findByVendorId(vendorId)
                .orElseThrow(() -> new RuntimeException("Score not found"));
    }
}