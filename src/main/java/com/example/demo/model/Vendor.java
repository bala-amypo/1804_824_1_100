package com.example.demo.model;
import jakarta.persistence.id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;

@Entity
public class Vendor{
 @Id
 @GenerateValue(status=GenerationType.IDENTITY)
 private Long id;
 @Column (unique=true)
 private String vendorName;
 private String email;
 private String phone;
 private String industry;
 private LocalDateTime createdAt;

 public Long getId()
 {
    return id;
 }
 public void setId(Long id)
 {
    this.id=id;
 }
 public String getVendorName()
 {
    return vendorName;
 }
 public void setVendorName()
 {
    
 }

}