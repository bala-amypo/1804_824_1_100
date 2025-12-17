package com.example.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.LocalDateTime;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;

@Entity

public class User
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique="true")
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    public Long getID()
    {
        return  id;
    }
    public void setId(Long id)
    {
        this.id=id;
    }
    public String getFullName()
    {
        return fullName;
    }
    public void setFullName(String fullName)
    {
        this.fullName=fullName;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role=role;
    }
    @PrePersist
    protected void onCreate()
    {
        this.createdAt=LocalDateTime.now();
    }
    public User(Long id,String fullName,String email,String password,String role,LocalDateTime createdAt)
    {
        this.id=id;
        this.fullName=fullName;
        this.email=email;
        this.password=password;
        this.role=role;
        this.createdAt=createdAt;
    }
    public User()
    {

    }
     
    


}