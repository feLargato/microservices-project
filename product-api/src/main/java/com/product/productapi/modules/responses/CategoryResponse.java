package com.product.productapi.modules.responses;

import com.product.productapi.modules.model.Category;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CategoryResponse {

    private Integer id;
    private String desc;

    public static CategoryResponse of(Category category) {
        var response = new CategoryResponse();
        BeanUtils.copyProperties(category, response);
        return response;
    }


}
