package com.product.productapi.modules.repository;

import com.product.productapi.modules.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
