package com.example.demo.service.impl;

import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.repository.VendorDocumentTypeRepository;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.stereotype.Service;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private VendorDocumentRepository vendorDocumentRepository;
    private VendorRepository vendorRepository;
    private VendorDocumentTypeRepository vendorDocumentTypeRepository;

    public ComplianceScoreServiceImpl(VendorDocumentRepository vendorDocumentRepository) {
        this.vendorDocumentRepository = vendorDocumentRepository;
    }

    public ComplianceScoreServiceImpl(
            VendorDocumentRepository vendorDocumentRepository,
            VendorRepository vendorRepository,
            VendorDocumentTypeRepository vendorDocumentTypeRepository
    ) {
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.vendorRepository = vendorRepository;
        this.vendorDocumentTypeRepository = vendorDocumentTypeRepository;
    }
}