package com.example.demo.repository;

import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VendorDocumentRepository extends JpaRepository<VendorDocument, Long> {

    // Used by your tests (keep this name!)
    @Query("SELECT d FROM VendorDocument d WHERE d.expiryDate < :date")
    List<VendorDocument> findExpiredDocuments(@Param("date") LocalDate date);

    // Used by your tests/service
    List<VendorDocument> findByVendor(Vendor vendor);
}