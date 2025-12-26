package com.example.demo.service.impl;

import com.example.demo.model.VendorDocument;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.service.VendorDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ✅ REQUIRED
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository vendorDocumentRepository;

    public VendorDocumentServiceImpl(VendorDocumentRepository vendorDocumentRepository) {
        this.vendorDocumentRepository = vendorDocumentRepository;
    }

    @Override
    public VendorDocument createVendorDocument(VendorDocument doc) {
        return vendorDocumentRepository.save(doc);
    }

    @Override
    public VendorDocument getVendorDocument(Long id) {
        return vendorDocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor document not found"));
    }

    @Override
    public List<VendorDocument> getAllVendorDocuments() {
        return vendorDocumentRepository.findAll();
    }
}
