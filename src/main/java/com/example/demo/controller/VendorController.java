package com.example.demo.controller;

import com.example.demo.dto.VendorRequest;
import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public Vendor create(@RequestBody VendorRequest req) {
        Vendor v = new Vendor();
        v.setVendorName(req.getVendorName());
        v.setEmail(req.getEmail());
        v.setPhone(req.getPhone());
        v.setIndustry(req.getIndustry());
        return vendorService.createVendor(v);
    }

    @GetMapping
    public List<Vendor> list() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public Vendor get(@PathVariable Long id) {
        return vendorService.getVendor(id);
    }
}