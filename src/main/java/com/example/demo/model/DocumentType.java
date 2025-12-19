package com.example.demo.model;
import jakarta.persistence.Enitity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType
@Entity
public class DocumentType
{
    @Id
    @GeneratedValue(Strategy=GenerationType.IDENTITY)
    

}