package com.product.productapi.modules.service;

import com.product.productapi.config.validations.Validations;
import com.product.productapi.modules.model.Category;
import com.product.productapi.modules.repository.CategoryRepository;
import com.product.productapi.modules.requests.CategoryRequest;
import com.product.productapi.modules.responses.CategoryResponse;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private Validations validations;

    public CategoryService(CategoryRepository categoryRepository, Validations validations) {
        this.categoryRepository = categoryRepository;
        this.validations = validations;
    }

    public CategoryResponse save(CategoryRequest categoryRequest) {
        validations.validateCategory(categoryRequest);
        Category savedCategory = categoryRepository.save(Category.of(categoryRequest));
        return CategoryResponse.of(savedCategory);
    }

}
