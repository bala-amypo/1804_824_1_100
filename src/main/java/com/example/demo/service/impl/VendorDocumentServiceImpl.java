package com.example.demo.service.impl;

import com.example.demo.model.VendorDocument;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.service.VendorDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository vendorDocumentRepository;

    public VendorDocumentServiceImpl(VendorDocumentRepository vendorDocumentRepository) {
        this.vendorDocumentRepository = vendorDocumentRepository;
    }

    @Override
    public VendorDocument uploadDocument(Long vendorId, Long typeId, VendorDocument document) {
        // minimal implementation – adjust later if needed
        return vendorDocumentRepository.save(document);
    }

    @Override
    public List<VendorDocument> getDocumentsForVendor(Long vendorId) {
        return vendorDocumentRepository.findAll(); // refine later
    }

    @Override
    public VendorDocument getDocument(Long id) {
        return vendorDocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor document not found"));
    }
}
