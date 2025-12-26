package com.example.demo.service.impl;

import com.example.demo.repository.DocumentTypeRepository;

public class DocumentTypeServiceImpl {
    private final DocumentTypeRepository repo;

    public DocumentTypeServiceImpl(DocumentTypeRepository repo) {
        this.repo = repo;
    }
}