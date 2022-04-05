package com.product.productapi.modules.model;

import com.product.productapi.modules.requests.CategoryRequest;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "description")
    private String desc;

    public static Category of(CategoryRequest categoryRequest) {
        var category = new Category();
        BeanUtils.copyProperties(categoryRequest, category);
        return category;
    }
}
