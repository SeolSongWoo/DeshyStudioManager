package com.deshy.stduio.deshystudiomanager.data.dto.product;

import com.deshy.stduio.deshystudiomanager.data.entity.ProductCategory;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class CategoryDTO {
    private String name;
    private UUID uid;


    public static CategoryDTO of(ProductCategory productCategory) {
        return CategoryDTO.builder()
                .name(productCategory.getCategory())
                .uid(productCategory.getUid())
                .build();
    }

    public static List<CategoryDTO> ofList(List<ProductCategory> productCategories) {
        return productCategories.stream().map(CategoryDTO::of).toList();
    }
}
