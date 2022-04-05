package com.product.productapi.modules.repository;

import com.product.productapi.modules.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
