package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;

public class VendorServiceImpl {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor createVendor(Vendor v) {
        return vendorRepository.save(v);
    }

    public Vendor getVendor(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
    }
}