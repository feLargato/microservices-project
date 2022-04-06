package com.product.productapi.modules.controllers;

import com.product.productapi.modules.requests.CategoryRequest;
import com.product.productapi.modules.responses.CategoryResponse;
import com.product.productapi.modules.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    public CategoryResponse save(@RequestBody CategoryRequest request) {

        return categoryService.save(request);
    }

    @GetMapping
    public List<CategoryResponse> findAll() {
       return categoryService.findAll();
    }

    @GetMapping("{id}")
    public CategoryResponse findById(@PathVariable Integer id) {
        return categoryService.findByIdResponse(id);
    }

    @GetMapping("desc/{desc}")
    public List<CategoryResponse> findByDesc(@PathVariable String desc) {
        return categoryService.findByDesc(desc);
    }

}
