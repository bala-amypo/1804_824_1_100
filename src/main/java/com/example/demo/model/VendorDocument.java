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
import com.example.demo.model.Vendor;
import jakarta.persistence.PrePersist;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DocumentType
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name= "vendor_id")
    private Vendor vendor;
    @Column(unique=true,nullable = false)
    private String fileUrl;
    private Boolean isValid;
    private LocalDateTime createdAt;
    private LocalDateTime expiryDate;
    @PrePersist
    protected void onCreate() {
    this.createdAt = LocalDateTime.now();
    @PrePersist
    protected void onCreated() {
    this.expiryDate = LocalDateTime.now();
}


}