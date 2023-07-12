package com.deshy.stduio.deshystudiomanager.data.dto.product;

import com.deshy.stduio.deshystudiomanager.data.entity.Product;
import com.deshy.stduio.deshystudiomanager.data.entity.ProductSale;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ProductDTO {
    private String name;
    private Long originPrice;
    private LocalDate purchaseDate;
    private Long stockQuantity;
    private String category;
    private String size;
    private String vendor;

    public static ProductDTO of(Product product) {
        return ProductDTO.builder()
                .name(product.getName())
                .originPrice(product.getOriginPrice())
                .purchaseDate(product.getPurchaseDate())
                .stockQuantity(product.getStockQuantity())
                .category(product.getCategory().getCategory())
                .size(product.getSize().getSize())
                .vendor(product.getVendor().getName())
                .build();
    }
    public static List<ProductDTO> ofList(List<Product> products) {
        return products.stream().map(ProductDTO::of).toList();
    }
}
