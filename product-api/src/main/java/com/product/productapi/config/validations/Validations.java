package com.product.productapi.config.validations;

import com.product.productapi.config.exceptions.ValidationException;
import com.product.productapi.modules.requests.CategoryRequest;
import com.product.productapi.modules.requests.ProductRequest;
import com.product.productapi.modules.requests.SupplierRequest;
import org.springframework.stereotype.Component;


import static org.springframework.util.ObjectUtils.isEmpty;

@Component
public class Validations {

    public void validateCategory(CategoryRequest categoryRequest) {
        if(isEmpty(categoryRequest.getDesc())) {
            throw new ValidationException("The category's description is empty");
        }
    }

    public void validateSupplier(SupplierRequest supplierRequest) {
        if(isEmpty(supplierRequest.getName())) {
            throw new ValidationException("The supplier's name is empty");
        }
    }

    public void validateProduct(ProductRequest productRequest) {
        if(isEmpty(productRequest.getName())) {
            throw new ValidationException("The product's name is empty");
        }
        else if(isEmpty(productRequest.getPrice())) {
            throw new ValidationException("The product must have a price");
        }
        else if(isEmpty(productRequest.getQuantity())) {
            throw new ValidationException("The quantity available of the product must to be informed");
        }
        else if(isEmpty(productRequest.getCategoryId())) {
            throw new ValidationException("The product must have a category");
        }
        else if(isEmpty(productRequest.getSupplierId())) {
            throw new ValidationException("The product must have a supplier");
        }

    }

}
