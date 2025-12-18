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
    private Boolean required;
    private int weight;
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
    public Boolean getrequired()
    {
        return required;
    }
    public void setrequired(Boolean required)
    {
        this.required=required;
    }
    public int getweight()
    {
        return weight;
    }
    public void setweight(int weight)
    {
        this.weight=weight;
    }
    @PrePersist
    protected void onCreate()
    {
        this.createdAt=LocalDateTime.now();
    }
    public DocumentType(Long id,String vendorName,String description,Boolean required,int weight,LocalDateTime createdAt)
    {
        this.id=id;
        this.typeName=typeName;
        this.description=description;
        this.required=required;
        this.weight=weight;
        this.createdAt=createdAt;
    }
    public DocumentType()
    {

    }
     
}