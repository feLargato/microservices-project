package com.product.productapi.modules.product.repository;

import com.product.productapi.modules.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
