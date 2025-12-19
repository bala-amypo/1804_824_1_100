package com.example.demo.service.implement;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;
import com.example.demo.repository.VendorRepository;
import java.util.List;


@Service
public class VendorServiceImpl implements VendorService
{
    private final VendorRepository obj;
    public VendorServiceImpl(VendorRepository obj)
    {
        this.obj=obj;
    }
    @Override
    public Vendor createVendor(Vendor vendor)
    {
        return obj.save(vendor);
    }
    @Override
    public Vendor getVendor(Long id){
        return obj.findById(id);
    }
    @Override
    public List<Vendor> getAllVendors()
    {
        return obj.findAll();
    }
}