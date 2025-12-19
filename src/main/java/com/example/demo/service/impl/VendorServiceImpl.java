package com.example.demo.service.implement;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;
import com.example.demo.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService
{
    private final VendorRepository obj;
    public VendorServiceImpl(VendorRepository obj)
    {
        this.obj=obj;
    }
    public Vendor 
}