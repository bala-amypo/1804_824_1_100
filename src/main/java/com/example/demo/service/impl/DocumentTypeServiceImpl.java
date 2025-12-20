package com.example.demo.service.impl;
import com.example.demo.service.DocumentTypeService;
import com.example.demo.repository.DocumentTypeRepository;
import org.springframework.stereotype.Service;
import com.example.demo.model.DocumentType;
import java.util.List;
 
@Service
public class DocumentTypeServiceImpl implements DocumentTypeService{
    private final DocumentTypeRepository obj;
    public DocumentTypeServiceImpl (DocumentTypeRepository obj)
    {
        this.obj=obj;
    }
    public DocumentType createDocumentType(DocumentType type)
    {
        return obj.save(Type);
    }
    public List<DocumentType> getAllDocumentTypes()
    {
        return obj.findAll();
    }
    public DocumentType getDocumentType(Long id)
    {
        return obj.findById(id);
    }
}
