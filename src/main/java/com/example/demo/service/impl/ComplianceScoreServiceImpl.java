package com.example.demo.service.impl;

import com.example.demo.repository.VendorDocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class ComplianceScoreServiceImpl {

    private final VendorDocumentRepository vendorDocumentRepository;

    public ComplianceScoreServiceImpl(VendorDocumentRepository vendorDocumentRepository) {
        this.vendorDocumentRepository = vendorDocumentRepository;
    }
}