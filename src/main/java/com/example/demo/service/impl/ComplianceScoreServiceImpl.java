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

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final VendorRepository vendorRepository;
    private final VendorDocumentRepository vendorDocumentRepository;
    private final ComplianceScoreRepository complianceScoreRepository;

    public ComplianceScoreServiceImpl(VendorRepository vendorRepository,
                                      VendorDocumentRepository vendorDocumentRepository,
                                      ComplianceScoreRepository complianceScoreRepository) {
        this.vendorRepository = vendorRepository;
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.complianceScoreRepository = complianceScoreRepository;
    }

    @Override
    public ComplianceScore evaluateVendor(Long vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        Set<DocumentType> supported = vendor.getSupportedDocumentTypes();
        double requiredTotalWeight = supported.stream()
                .filter(DocumentType::isRequired)
                .mapToDouble(DocumentType::getWeight)
                .sum();

        double score;

        if (requiredTotalWeight == 0.0) {
            score = 100.0;
        } else {
            List<VendorDocument> docs = vendorDocumentRepository.findByVendorId(vendorId);

            double satisfiedWeight = supported.stream()
                    .filter(DocumentType::isRequired)
                    .filter(type -> hasValidDoc(docs, type.getId()))
                    .mapToDouble(DocumentType::getWeight)
                    .sum();

            score = (satisfiedWeight / requiredTotalWeight) * 100.0;
        }

        ComplianceScore cs = complianceScoreRepository.findByVendorId(vendorId)
                .orElse(new ComplianceScore());

        cs.setVendor(vendor);
        cs.setScoreValue(score);
        cs.setRating(ratingFromScore(score));

        return complianceScoreRepository.save(cs);
    }

    @Override
    public ComplianceScore getScore(Long vendorId) {
        return complianceScoreRepository.findByVendorId(vendorId)
                .orElseThrow(() -> new RuntimeException("Score not found"));
    }

    private boolean hasValidDoc(List<VendorDocument> docs, Long typeId) {
        LocalDate today = LocalDate.now();
        return docs.stream().anyMatch(d ->
                d.getDocumentType() != null &&
                typeId.equals(d.getDocumentType().getId()) &&
                d.getExpiryDate() != null &&
                !d.getExpiryDate().isBefore(today)
        );
    }

    private String ratingFromScore(double score) {
        if (score >= 100.0) return "COMPLIANT";
        if (score >= 50.0) return "PARTIALLY_COMPLIANT";
        return "NON_COMPLIANT";
    }
}