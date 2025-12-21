package com.example.demo.repository;
import java.util.List;
import com.example.demo.model.VendorDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VendorDocumentRepository extends JpaRepository<VendorDocument, Long> {
List<VendorDocument> findByVendorId(Long vendorId);
}
