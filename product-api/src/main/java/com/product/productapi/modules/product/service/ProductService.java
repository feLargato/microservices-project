package com.product.productapi.modules.product.service;

import com.product.productapi.modules.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private CategoryRepository categoryRepository;
}
