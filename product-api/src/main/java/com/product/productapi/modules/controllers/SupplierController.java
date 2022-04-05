package com.product.productapi.modules.controllers;

import com.product.productapi.modules.requests.SupplierRequest;
import com.product.productapi.modules.responses.SupplierResponse;
import com.product.productapi.modules.service.SupplierService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/supplier")
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }


    @PostMapping
    public SupplierResponse save(@RequestBody SupplierRequest request) {

        return supplierService.save(request);
    }

}
