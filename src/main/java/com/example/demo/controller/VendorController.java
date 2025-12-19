package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/api/vendors")
public class VendorController
{
    private final VendorService obj;
    public VendorController (VendorService obj)
    {
        this.obj=obj;
    }
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor)
    {
        return obj.createVendor(vendor);
    }
    @GetMapping
    public Vendor getvendor(Long id)
    {
        
    }
    
    
}