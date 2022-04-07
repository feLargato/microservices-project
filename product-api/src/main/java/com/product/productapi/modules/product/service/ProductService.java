package com.product.productapi.modules.product.service;

import com.product.productapi.config.exceptions.ValidationException;
import com.product.productapi.config.responses.Response;
import com.product.productapi.config.validations.Validations;
import com.product.productapi.modules.product.dto.ProductStock;
import com.product.productapi.modules.product.model.Product;
import com.product.productapi.modules.product.repository.ProductRepository;
import com.product.productapi.modules.product.dto.ProductRequest;
import com.product.productapi.modules.product.dto.ProductResponse;
import com.product.productapi.modules.category.service.CategoryService;
import com.product.productapi.modules.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private Validations validations;

    public ProductResponse save(ProductRequest productRequest) {
        validations.validateProduct(productRequest);
        var category = categoryService.findById(productRequest.getCategoryId());
        var supplier = supplierService.findById(productRequest.getSupplierId());
        var product = productRepository.save(Product.of(productRequest, category, supplier));
        return ProductResponse.of(product);
    }

    public ProductResponse update(ProductRequest productRequest, Integer id) {
        if(isEmpty(id)) {
            throw new ValidationException("Product id must be informed");
        }
        validations.validateProduct(productRequest);
        var category = categoryService.findById(productRequest.getCategoryId());
        var supplier = supplierService.findById(productRequest.getSupplierId());
        var product = Product.of(productRequest, category, supplier);
        product.setId(id);
        productRepository.save(product);
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

    public Response delete(Integer id) {
        productRepository.deleteById(id);
        return Response.successResponse("Product deleted");
    }

    public boolean existsByCategoryId(Integer categoryId) {
        return productRepository.existsByCategoryId(categoryId);
    }

    public boolean existsBySupplierId(Integer supplierId) {
        return productRepository.existsBySupplierId(supplierId);
    }

    public void updateProductStock(ProductStock productStock) {

    }

}
