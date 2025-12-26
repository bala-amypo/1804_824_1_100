package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;

import java.time.LocalDate;

public class VendorDocumentServiceImpl {

    private final VendorDocumentRepository vendorDocumentRepository;
    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;

    public VendorDocumentServiceImpl(VendorDocumentRepository vendorDocumentRepository,
                                    VendorRepository vendorRepository,
                                    DocumentTypeRepository documentTypeRepository) {
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
    }

    public VendorDocument uploadDocument(Long vendorId, Long docTypeId, VendorDocument doc) {
        if (doc != null && doc.getExpiryDate() != null && doc.getExpiryDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Expiry date cannot be in the past");
        }

        Vendor v = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        DocumentType dt = documentTypeRepository.findById(docTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("DocumentType not found"));

        doc.setVendor(v);
        doc.setDocumentType(dt);

        return vendorDocumentRepository.save(doc);
    }

    public VendorDocument getDocument(Long id) {
        return vendorDocumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VendorDocument not found"));
    }
}