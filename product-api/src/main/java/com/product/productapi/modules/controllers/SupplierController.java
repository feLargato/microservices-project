package com.product.productapi.modules.controllers;

import com.product.productapi.modules.model.Supplier;
import com.product.productapi.modules.requests.SupplierRequest;
import com.product.productapi.modules.responses.SupplierResponse;
import com.product.productapi.modules.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-api/supplier")
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }


    @PostMapping
    public SupplierResponse save(@RequestBody SupplierRequest request) {

        return supplierService.save(request);
    }

    @GetMapping
    public List<SupplierResponse> findByAll() {

        return supplierService.findAll();
    }

    @GetMapping("{id}")
    public SupplierResponse findById(@PathVariable Integer id) {
        return  supplierService.findByIdSupplierResponse(id);
    }

    @GetMapping("name/{name}")
    public List<SupplierResponse> findByName(@PathVariable String name) {
        return supplierService.findByName(name);
    }

}
