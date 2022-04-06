package com.product.productapi.modules.controllers;


import com.product.productapi.modules.requests.ProductRequest;
import com.product.productapi.modules.responses.ProductResponse;
import com.product.productapi.modules.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponse save(@RequestBody ProductRequest productRequest) {
        return productService.save(productRequest);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @GetMapping("/name/{name}")
    public List<ProductResponse> findByName(@PathVariable String name) {

        return productService.findByName(name);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<ProductResponse> findBySupplierId(@PathVariable Integer supplierId) {
        return productService.findBySupplierId(supplierId);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductResponse> findByCategoryId(@PathVariable Integer categoryId) {
        return productService.findByCategoryId(categoryId);
    }

    @GetMapping("/category/name/{categoryDesc}")
    public List<ProductResponse> findByCategoryDesc(@PathVariable String categoryDesc) {
        return productService.findByCategoryDesc(categoryDesc);
    }


}
