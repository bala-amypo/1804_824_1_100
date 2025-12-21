package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.demo.model.Vendor;
import com.example.demo.model.DocumentType;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.VendorRepository;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.service.VendorDocumentService;

@Service
@RequiredArgsConstructor
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository vendorDocumentRepository;
    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;

    @Override
    public VendorDocument uploadDocument(Long vendorId, Long typeId, VendorDocument document) {

        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow();
        DocumentType documentType = documentTypeRepository.findById(typeId).orElseThrow();

        document.setVendor(vendor);
        document.setDocumentType(documentType);

        if (document.getExpiryDate() == null || document.getExpiryDate().isAfter(LocalDateTime.now())) {
            document.setIsValid(true);
        } else {
            document.setIsValid(false);
        }

        return vendorDocumentRepository.save(document);
    }

    @Override
    public List<VendorDocument> getDocumentsForVendor(Long vendorId) {
        return vendorDocumentRepository.findByVendorId(vendorId);
    }

    @Override
    public VendorDocument getDocument(Long id) {
        return vendorDocumentRepository.findById(id).orElseThrow();
    }
}