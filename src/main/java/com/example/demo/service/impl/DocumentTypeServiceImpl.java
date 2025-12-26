package com.example.demo.service.impl;

import com.example.demo.model.DocumentType;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.service.DocumentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ✅ REQUIRED
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeRepository repo;

    public DocumentTypeServiceImpl(DocumentTypeRepository repo) {
        this.repo = repo;
    }

    @Override
    public DocumentType create(DocumentType docType) {
        return repo.save(docType);
    }

    @Override
    public List<DocumentType> getAll() {
        return repo.findAll();
    }

    @Override
    public DocumentType getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("DocumentType not found"));
    }
}
