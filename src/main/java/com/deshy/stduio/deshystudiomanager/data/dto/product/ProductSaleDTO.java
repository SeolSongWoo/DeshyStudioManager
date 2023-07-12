package com.deshy.stduio.deshystudiomanager.data.dto.product;

import com.deshy.stduio.deshystudiomanager.data.entity.ProductSale;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSaleDTO {
    private LocalDateTime saleDate;
    private String productName;
    private Long saleQuantity;
    private Long salePrice;
    private Long originPrice;

    public static ProductSaleDTO of(ProductSale productSale) {
        return ProductSaleDTO.builder()
                .saleDate(productSale.getSaleDate())
                .productName(productSale.getProduct().getName())
                .saleQuantity(productSale.getSaleQuantity())
                .salePrice(productSale.getSalePrice())
                .originPrice(productSale.getProduct().getOriginPrice())
                .build();
    }
    public static List<ProductSaleDTO> ofList(List<ProductSale> productSales) {
        return productSales.stream().map(ProductSaleDTO::of).toList();
    }
}
