package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository vendorDocumentRepository;
    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;

    public VendorDocumentServiceImpl(VendorDocumentRepository vendorDocumentRepository) {
        this(vendorDocumentRepository, null, null);
    }

    public VendorDocumentServiceImpl(
            VendorDocumentRepository vendorDocumentRepository,
            VendorRepository vendorRepository,
            DocumentTypeRepository documentTypeRepository
    ) {
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
    }

    @Override
    public VendorDocument getDocument(Long id) {
        return vendorDocumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VendorDocument not found with id: " + id));
    }

    @Override
    public List<VendorDocument> getDocumentsForVendor(Long vendorId) {
        return vendorDocumentRepository.findAll().stream()
                .filter(d -> d.getVendor() != null
                        && d.getVendor().getId() != null
                        && d.getVendor().getId().equals(vendorId))
                .toList();
    }

    public List<VendorDocument> getAllDocuments() {
        return vendorDocumentRepository.findAll();
    }

    public VendorDocument saveDocument(VendorDocument vendorDocument) {
        return vendorDocumentRepository.save(vendorDocument);
    }

    public void deleteDocument(Long id) {
        vendorDocumentRepository.deleteById(id);
    }
}