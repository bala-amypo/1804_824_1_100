package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.DocumentTypeService;
import com.example.demo.model.DocumentType;
import java.util.List;
@RestController
@RequestMapping("/api/document-types")
public class DocumentTypeController
{
    private final DocumentTypeService obj;
    public DocumentTypeController (DocumentTypeService obj)
    {
        this.obj=obj;
    }
    @PostMapping
    public DocumentType createendor(@RequestBody DocumentType vendor)
    {
        return obj.createVendor(vendor);
    }
    @GetMapping
    public List<DocumentType> getAllVendors()
    {
        return obj.getAllDocumentTypes();
    }
    @GetMapping("/{id}")
    public DocumentType getVendor(Long id)
    {
        return obj.getDocumentTypes(id);
    }
    
    
}