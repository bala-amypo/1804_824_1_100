package com.example.demo.service.impl;
import com.example.demo.service.DocumentTypeService;
import com.example.demo.repository.DocumentTypeRepository;
import org.springframework.stereotype.Service;
 
@Service
public interface DocumentTypeServiceImpl implements DocumentTypeService
{
    private final DocumentTypeRepository obj;
    public DocumentTypeServiceImpl (DocumentTypeRepository obj)
    {
        this.obj=obj;
    }
    
}