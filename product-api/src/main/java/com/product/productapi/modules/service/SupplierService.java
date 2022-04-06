package com.product.productapi.modules.service;

import com.product.productapi.config.exceptions.ValidationException;
import com.product.productapi.config.validations.Validations;
import com.product.productapi.modules.model.Supplier;
import com.product.productapi.modules.repository.SupplierRepository;
import com.product.productapi.modules.requests.SupplierRequest;
import com.product.productapi.modules.responses.CategoryResponse;
import com.product.productapi.modules.responses.SupplierResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public SupplierResponse findByIdSupplierResponse(Integer id) {
        return SupplierResponse.of(findById(id));
    }

    public Supplier findById(Integer id) {
         return supplierRepository
                 .findById(id)
                 .orElseThrow(() -> new ValidationException("No supplier found for the id: " + id));
    }

    public List<SupplierResponse> findAll() {
        return supplierRepository
                .findAll()
                .stream()
                .map(SupplierResponse::of)
                .collect(Collectors.toList());
    }

    public List<SupplierResponse> findByName(String name) {
        return supplierRepository
                .findByNameIgnoreCaseContaining(name)
                .stream()
                .map(SupplierResponse::of)
                .collect(Collectors.toList());
    }



}
