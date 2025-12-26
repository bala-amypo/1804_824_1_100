package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
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
    public VendorDocument uploadDocument(Long vendorId, Long documentTypeId, VendorDocument vendorDocument) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found with id: " + vendorId));

        DocumentType documentType = documentTypeRepository.findById(documentTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("DocumentType not found with id: " + documentTypeId));

        vendorDocument.setVendor(vendor);
        vendorDocument.setDocumentType(documentType);

        return vendorDocumentRepository.save(vendorDocument);
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
}