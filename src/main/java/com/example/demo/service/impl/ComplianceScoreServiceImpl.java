package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ComplianceScore;
import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.util.ComplianceScoringEngine;

import java.util.ArrayList;
import java.util.List;

public class ComplianceScoreServiceImpl {

    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;
    private final VendorDocumentRepository vendorDocumentRepository;
    private final ComplianceScoreRepository complianceScoreRepository;

    private final ComplianceScoringEngine engine = new ComplianceScoringEngine();

    public ComplianceScoreServiceImpl(VendorRepository vendorRepository,
                                     DocumentTypeRepository documentTypeRepository,
                                     VendorDocumentRepository vendorDocumentRepository,
                                     ComplianceScoreRepository complianceScoreRepository) {
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.complianceScoreRepository = complianceScoreRepository;
    }

    public ComplianceScore evaluateVendor(Long vendorId) {
        Vendor v = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        List<DocumentType> requiredTypes = documentTypeRepository.findByRequiredTrue();
        List<VendorDocument> docs = vendorDocumentRepository.findByVendor(v);

        List<DocumentType> submitted = new ArrayList<>();
        for (VendorDocument d : docs) {
            if (Boolean.TRUE.equals(d.getIsValid()) && d.getDocumentType() != null) {
                submitted.add(d.getDocumentType());
            }
        }

        double scoreValue = engine.calculateScore(requiredTypes, submitted);
        String rating = engine.deriveRating(scoreValue);

        ComplianceScore score = complianceScoreRepository.findByVendor_Id(vendorId)
                .orElseGet(ComplianceScore::new);

        score.setVendor(v);
        score.setScoreValue(scoreValue);
        score.setRating(rating);

        return complianceScoreRepository.save(score);
    }

    public ComplianceScore getScore(Long vendorId) {
        return complianceScoreRepository.findByVendor_Id(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found"));
    }
}