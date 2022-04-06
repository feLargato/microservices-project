package com.product.productapi.modules.repository;

import com.product.productapi.modules.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNameIgnoreCaseContaining(String name);

    List<Product> findByCategoryId(Integer categoryId);

    List<Product> findBySupplierId(Integer supplierId);

    List<Product> findByCategoryDescIgnoreCaseContaining(String categoryName);

}
