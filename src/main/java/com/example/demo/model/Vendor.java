package com.example.demo.model;
import jakarta.persistence.id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

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

 

}