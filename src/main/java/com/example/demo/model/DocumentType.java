package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
public class DocumentType
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String typeName;
    private String description;
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
    public String gettypeName()
    {
        return typeName;
    }
    public void settypeName(String typeName)
    {
        this.typeName=typeName;
    }
    public String getdescription()
    {
        return description;
    }
    public void setdescription(String description)
    {
        this.description=description;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String password)
    {
        this.phone=phone;
    }
    public String getIndustry()
    {
        return industry;
    }
    public void setIndustry(String role)
    {
        this.industry=industry;
    }
    @PrePersist
    protected void onCreate()
    {
        this.createdAt=LocalDateTime.now();
    }
    public DocumentType(Long id,String vendorName,String description,String phone,String industry,LocalDateTime createdAt)
    {
        this.id=id;
        this.vendorName=vendorName;
        this.description=description;
        this.phone=phone;
        this.industry=industry;
        this.createdAt=createdAt;
    }
    public DocumentType()
    {

    }
     
}