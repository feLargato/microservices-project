package com.product.productapi.modules.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Product {

    @Id
    private Integer id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    @Column(name = "description")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "FK_CATEGORY", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "FK_SUPPLIER", nullable = false)
    private Supplier supplier;


}
