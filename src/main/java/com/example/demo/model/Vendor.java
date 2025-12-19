package com.example.demo.model;
import jakarta.persistence.id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Vendor{
 @Id
 @GenerateValue(status=GenerationType.IDENTITY)
 private Long id;
 @Column (unique=true)

}