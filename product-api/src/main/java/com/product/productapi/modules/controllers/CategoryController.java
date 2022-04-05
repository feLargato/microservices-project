package com.product.productapi.modules.controllers;


import com.product.productapi.modules.model.Category;
import com.product.productapi.modules.requests.CategoryRequest;
import com.product.productapi.modules.responses.CategoryResponse;
import com.product.productapi.modules.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    public CategoryResponse save(@RequestBody CategoryRequest request) {

        return categoryService.save(request);
    }



}
