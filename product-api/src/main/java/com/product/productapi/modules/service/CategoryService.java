package com.product.productapi.modules.service;

import com.product.productapi.config.exceptions.ValidationException;
import com.product.productapi.config.validations.Validations;
import com.product.productapi.modules.model.Category;
import com.product.productapi.modules.repository.CategoryRepository;
import com.product.productapi.modules.requests.CategoryRequest;
import com.product.productapi.modules.responses.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public Category findById(Integer id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("No category found for the id: " + id));
    }

    public CategoryResponse findByIdResponse(Integer id) {
        return CategoryResponse.of(findById(id));
    }

    public List<CategoryResponse> findAll() {
        return categoryRepository
                .findAll()
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    public List<CategoryResponse> findByDesc(String desc) {
        return categoryRepository
                .findByDescIgnoreCaseContaining(desc)
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

}
