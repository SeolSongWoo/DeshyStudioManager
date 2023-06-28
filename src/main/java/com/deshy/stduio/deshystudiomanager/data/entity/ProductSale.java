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
    @Column(name = "sale_quantity", nullable = false)
    private Long saleQuantity;
    @Column(name = "sale_price", nullable = false)
    private Long salePrice;
    @Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
