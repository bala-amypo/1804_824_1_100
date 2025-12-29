@Service
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository vendorDocumentRepository;
    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;

    public VendorDocumentServiceImpl(
            VendorDocumentRepository vendorDocumentRepository,
            VendorRepository vendorRepository,
            DocumentTypeRepository documentTypeRepository
    ) {
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
    }

    @Override
    public VendorDocument uploadDocument(Long vendorId, Long typeId, VendorDocument document) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vendor not found with id: " + vendorId));

        DocumentType type = documentTypeRepository.findById(typeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Document type not found with id: " + typeId));

        // ✅ Test-compliant expiry validation
        if (document.getExpiryDate() != null &&
                document.getExpiryDate().isBefore(LocalDate.now())) {

            throw new IllegalArgumentException("Expiry date cannot be in the past");
        }

        document.setVendor(vendor);
        document.setDocumentType(type);
        return vendorDocumentRepository.save(document);
    }

    @Override
    public VendorDocument getDocument(Long id) {
        return vendorDocumentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("VendorDocument not found"));
    }

    @Override
    public List<VendorDocument> getDocumentsForVendor(Long vendorId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vendor not found with id: " + vendorId));

        return vendorDocumentRepository.findByVendor(vendor);
    }
}