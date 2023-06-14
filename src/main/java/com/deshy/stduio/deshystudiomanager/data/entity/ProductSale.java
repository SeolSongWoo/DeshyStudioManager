package com.deshy.stduio.deshystudiomanager.data.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "product_sale")
public class ProductSale {

    @Id
    @GeneratedValue
    private Long productSaleId;
    private Long saleQuantity;
    private Long salePrice;
    private LocalDateTime saleDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
