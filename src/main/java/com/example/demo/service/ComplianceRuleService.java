package com.example.demo.service;
import com.example.demo.model.ComplianceRule;

import java.util.List;

public interface ComplianceRuleService
{
    ComplianceRule createRule(ComplianceRule rule);
    List<ComplianceRule> getAllRules();
    ComplianceRule getRule(Long id);
}


package com.example.demo.service;

import com.example.demo.model.ComplianceScore;

public interface ComplianceScoreService {
    ComplianceScore evaluateVendor(Long vendorId);
    ComplianceScore getScore(Long vendorId);
}

package com.example.demo.service;
import java.util.List;
import com.example.demo.model.DocumentType;


public interface DocumentTypeService
{
    DocumentType createDocumentType(DocumentType type);
    List<DocumentType> getAllDocumentTypes();
    DocumentType getDocumentType(Long id);
}

package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
    User getUser(Long id);
}

package com.example.demo.service;

import com.example.demo.model.VendorDocument;
import java.util.List;

public interface VendorDocumentService {
    VendorDocument uploadDocument(Long vendorId, Long documentTypeId, VendorDocument doc);
    VendorDocument getDocument(Long id);
    List<VendorDocument> getDocumentsForVendor(Long vendorId);
}

package com.example.demo.service;
import java.util.List;
import com.example.demo.model.Vendor;

public interface VendorService 
{
    Vendor createVendor(Vendor vendor);
    Vendor getVendor(Long id);
    List<Vendor> getAllVendors();
}
