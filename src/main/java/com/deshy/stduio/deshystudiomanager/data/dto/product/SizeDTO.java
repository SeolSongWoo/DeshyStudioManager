package com.deshy.stduio.deshystudiomanager.data.dto.product;

import com.deshy.stduio.deshystudiomanager.data.entity.ProductCategory;
import com.deshy.stduio.deshystudiomanager.data.entity.ProductSize;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class SizeDTO {
    private String name;
    private UUID uid;

    public static SizeDTO of(ProductSize productSize) {
        return SizeDTO.builder()
                .name(productSize.getSize())
                .uid(productSize.getUid())
                .build();
    }

    public static List<SizeDTO> ofList(List<ProductSize> productSizes) {
        return productSizes.stream().map(SizeDTO::of).toList();
    }
}
