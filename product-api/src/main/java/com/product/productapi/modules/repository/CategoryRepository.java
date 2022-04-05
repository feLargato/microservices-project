package com.product.productapi.modules.repository;

import com.product.productapi.modules.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
