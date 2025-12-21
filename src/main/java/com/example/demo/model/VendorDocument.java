package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "document_type_id", nullable = false)
    private DocumentType documentType;

    @Column(nullable = false)
    private String fileUrl;

    private LocalDateTime uploadedAt;

    private LocalDateTime expiryDate;

    private Boolean isValid;

    @PrePersist
    protected void onCreate() {
        this.uploadedAt = LocalDateTime.now();
        this.isValid = (expiryDate == null || expiryDate.isAfter(LocalDateTime.now()));
    }
}