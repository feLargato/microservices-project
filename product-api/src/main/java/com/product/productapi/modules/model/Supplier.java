package com.product.productapi.modules.model;

import com.product.productapi.modules.requests.CategoryRequest;
import com.product.productapi.modules.requests.SupplierRequest;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;

    public static Supplier of(SupplierRequest supplierRequest) {
        var supplier = new Supplier();
        BeanUtils.copyProperties(supplierRequest, supplier);
        return supplier;
    }

}
