// package com.example.demo.service.impl;

// import com.example.demo.model.DocumentType;
// import com.example.demo.model.Vendor;
// import com.example.demo.model.VendorDocument;
// import com.example.demo.repository.DocumentTypeRepository;
// import com.example.demo.repository.VendorDocumentRepository;
// import com.example.demo.repository.VendorRepository;
// import com.example.demo.service.VendorDocumentService;
// import org.springframework.stereotype.Service;

// import java.time.LocalDate;
// import java.util.List;

// @Service
// public class VendorDocumentServiceImpl implements VendorDocumentService {

//     private final VendorDocumentRepository vendorDocumentRepository;
//     private final VendorRepository vendorRepository;
//     private final DocumentTypeRepository documentTypeRepository;

//     public VendorDocumentServiceImpl(
//             VendorDocumentRepository vendorDocumentRepository,
//             VendorRepository vendorRepository,
//             DocumentTypeRepository documentTypeRepository
//     ) {
//         this.vendorDocumentRepository = vendorDocumentRepository;
//         this.vendorRepository = vendorRepository;
//         this.documentTypeRepository = documentTypeRepository;
//     }

//     @Override
//     public VendorDocument uploadDocument(Long vendorId, Long typeId, VendorDocument document) {
//         Vendor vendor = vendorRepository.findById(vendorId).orElseThrow();
//         DocumentType type = documentTypeRepository.findById(typeId).orElseThrow();

//         if (document.getExpiryDate() != null &&
//             document.getExpiryDate().isBefore(LocalDate.now())) {
//             throw new IllegalArgumentException("Document expired");
//         }

//         document.setVendor(vendor);
//         document.setDocumentType(type);
//         return vendorDocumentRepository.save(document);
//     }

//     @Override
//     public VendorDocument getDocument(Long id) {
//         return vendorDocumentRepository.findById(id).orElse(null);
//     }

//     @Override
//     public List<VendorDocument> getDocumentsForVendor(Long vendorId) {
//         Vendor vendor = vendorRepository.findById(vendorId).orElseThrow();
//         return vendorDocumentRepository.findByVendor(vendor);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ComplianceScore;
import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;
    private final VendorDocumentRepository vendorDocumentRepository;
    private final ComplianceScoreRepository complianceScoreRepository;

    public ComplianceScoreServiceImpl(
            VendorRepository vendorRepository,
            DocumentTypeRepository documentTypeRepository,
            VendorDocumentRepository vendorDocumentRepository,
            ComplianceScoreRepository complianceScoreRepository
    ) {
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.complianceScoreRepository = complianceScoreRepository;
    }

    @Override
    public ComplianceScore evaluateVendor(Long vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        Set<DocumentType> requiredTypes = vendor.getSupportedDocumentTypes();

        if (requiredTypes == null || requiredTypes.isEmpty()) {
            return saveScore(vendor, 100.0);
        }

        List<VendorDocument> documents = vendorDocumentRepository.findByVendor(vendor);

        long validCount = requiredTypes.stream()
                .filter(dt ->
                        documents.stream().anyMatch(d ->
                                d.getDocumentType() != null &&
                                        d.getDocumentType().equals(dt) &&
                                        (d.getExpiryDate() == null || d.getExpiryDate().isAfter(LocalDate.now()))
                        )
                )
                .count();

        double score = (validCount * 100.0) / requiredTypes.size();
        return saveScore(vendor, score);
    }

    @Override
    public ComplianceScore getScore(Long vendorId) {
        return complianceScoreRepository.findByVendor_Id(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found"));
    }

    private ComplianceScore saveScore(Vendor vendor, double scoreValue) {
        ComplianceScore score = complianceScoreRepository.findByVendor_Id(vendor.getId())
                .orElse(new ComplianceScore());

        score.setVendor(vendor);
        score.setScoreValue(scoreValue);
        score.setRating(getRating(scoreValue));

        return complianceScoreRepository.save(score);
    }

    private String getRating(double score) {
        if (score >= 90.0) return "EXCELLENT";
        if (score >= 70.0) return "GOOD";
        if (score >= 40.0) return "AVERAGE";
        return "POOR";
    }
}