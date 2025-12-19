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
 public void setVendorName(String vendorName)
 {
    this.vendorName=vendorName;
 }
 public String getEmail()
 {
    return email;
 }
 public void setEmail(String email)
{
    this.email=email;
}
public String getPhone()
{
    return phone;
}
public void setPhone(String phone)
{
    this.phone=phone;
}
public String getIndustry()
{
    return industry;
}
public void setIndustry()
{
    this.industry=industry;
}
public Vendor(Long id,String vendorName,String email,String phone,String industry,LocalDateTime createdAt)
{
    this.id=id;
    this.vendorName=vendorName;
    this.email=email;
    this.phone=phone;
    this.industry=industry;
    this.createdAt=createdAt;

public Vendor()
{

}
}
}