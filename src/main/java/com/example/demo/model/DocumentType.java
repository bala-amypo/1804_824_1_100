package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class DocumentType
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String typeName;
    private String description;
    private Boolean required;
    private int weight;
    private LocalDateTime createdAt;


}