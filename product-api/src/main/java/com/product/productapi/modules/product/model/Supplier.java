package com.product.productapi.modules.product.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Supplier {

    @Id
    private Integer id;
    private String name;

}
