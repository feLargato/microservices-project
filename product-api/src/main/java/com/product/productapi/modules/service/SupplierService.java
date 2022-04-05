package com.product.productapi.modules.service;

import com.product.productapi.config.validations.Validations;
import com.product.productapi.modules.model.Supplier;
import com.product.productapi.modules.repository.SupplierRepository;
import com.product.productapi.modules.requests.SupplierRequest;
import com.product.productapi.modules.responses.SupplierResponse;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;
    private Validations validations;

    public SupplierService(SupplierRepository supplierRepository, Validations validations) {
        this.supplierRepository = supplierRepository;
        this.validations = validations;
    }

    public SupplierResponse save(SupplierRequest supplierRequest) {
        validations.validateSupplier(supplierRequest);
        Supplier savedSupplier = supplierRepository.save(Supplier.of(supplierRequest));
        return SupplierResponse.of(savedSupplier);
    }

}
