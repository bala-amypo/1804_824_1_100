package com.example.demo.service.impl;

import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import org.springframework.stereotype.Service;

@Service
public class ComplianceScoreServiceImpl {

    private final VendorDocumentRepository vendorDocumentRepository;
    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;

    public ComplianceScoreServiceImpl(VendorDocumentRepository vendorDocumentRepository) {
        this(vendorDocumentRepository, null, null);
    }

    public ComplianceScoreServiceImpl(
            VendorDocumentRepository vendorDocumentRepository,
            VendorRepository vendorRepository,
            DocumentTypeRepository documentTypeRepository
    ) {
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
    }

    public void evaluateVendor(long vendorId) {
        evaluateVendor(Long.valueOf(vendorId));
    }

    public void evaluateVendor(Long vendorId) {
    }

    public int getScore(long vendorId) {
        return getScore(Long.valueOf(vendorId));
    }

    public int getScore(Long vendorId) {
        return 0;
    }
}