package com.product.productapi.modules.product.repository;

import com.product.productapi.modules.product.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
