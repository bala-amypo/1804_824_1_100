package com.example.demo.service.implement;

import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorDocumentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository vendorDocumentRepo;
    private final VendorRepository vendorRepo;
    private final DocumentTypeRepository documentTypeRepo;

    public VendorDocumentServiceImpl(
            VendorDocumentRepository vendorDocumentRepo,
            VendorRepository vendorRepo,
            DocumentTypeRepository documentTypeRepo
    ) {
        this.vendorDocumentRepo = vendorDocumentRepo;
        this.vendorRepo = vendorRepo;
        this.documentTypeRepo = documentTypeRepo;
    }

    @Override
    public VendorDocument uploadDocument(Long vendorId, Long typeId, VendorDocument document) {
        if (document.getFileUrl() == null || document.getFileUrl().isBlank()) {
            throw new IllegalArgumentException("fileUrl is required");
        }

        Vendor vendor = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        DocumentType type = documentTypeRepo.findById(typeId)
                .orElseThrow(() -> new RuntimeException("DocumentType not found"));

        LocalDateTime now = LocalDateTime.now();

        document.setVendor(vendor);
        document.setDocumentType(type);
        document.setUploadedAt(now);

        if (document.getExpiryDate() != null && !document.getExpiryDate().isAfter(now)) {
            throw new IllegalArgumentException("expiryDate must be in the future");
        }

        document.setIsValid(document.getExpiryDate() == null || document.getExpiryDate().isAfter(now));

        return vendorDocumentRepo.save(document);
    }

    @Override
    public List<VendorDocument> getDocumentsForVendor(Long vendorId) {
        return vendorDocumentRepo.findByVendorId(vendorId);
    }

    @Override
    public VendorDocument getDocument(Long id) {
        return vendorDocumentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("VendorDocument not found"));
    }
}