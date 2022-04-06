package com.product.productapi.modules.service;

import com.product.productapi.config.validations.Validations;
import com.product.productapi.modules.model.Product;
import com.product.productapi.modules.repository.ProductRepository;
import com.product.productapi.modules.requests.ProductRequest;
import com.product.productapi.modules.responses.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;
    private SupplierService supplierService;
    private Validations validations;


    public ProductService(ProductRepository productRepository, SupplierService supplierService, CategoryService categoryService, Validations validations) {
        this.productRepository = productRepository;
        this.supplierService = supplierService;
        this.categoryService = categoryService;
        this.validations = validations;
    }


    public ProductResponse save(ProductRequest productRequest) {
        validations.validateProduct(productRequest);
        var category = categoryService.findById(productRequest.getCategoryId());
        var supplier = supplierService.findById(productRequest.getSupplierId());
        var product = productRepository.save(Product.of(productRequest, category, supplier));
        return ProductResponse.of(product);
    }

    public List<ProductResponse> findAll() {
        return productRepository.
                findAll().
                stream().
                map(ProductResponse::of)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> findByName(String name) {
        return productRepository
                .findByNameIgnoreCaseContaining(name)
                .stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> findBySupplierId(Integer supplierId) {
        return productRepository
                .findBySupplierId(supplierId)
                .stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> findByCategoryId(Integer categoryId) {
        return productRepository
                .findByCategoryId(categoryId)
                .stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> findByCategoryDesc(String categoryDesc) {
        return productRepository
                .findByCategoryDescIgnoreCaseContaining(categoryDesc)
                .stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }



}
