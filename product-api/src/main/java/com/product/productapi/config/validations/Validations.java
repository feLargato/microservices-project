package com.product.productapi.config.validations;

import com.product.productapi.config.exceptions.ValidationException;
import com.product.productapi.modules.requests.CategoryRequest;
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
}
