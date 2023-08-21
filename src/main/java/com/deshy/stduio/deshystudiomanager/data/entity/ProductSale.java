package com.deshy.stduio.deshystudiomanager.data.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name = "product_sale")
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "payment",nullable = false)
    private String payment;

    private UUID uid = UUID.randomUUID();



    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    protected ProductSale(Long saleQuantity, Long salePrice, LocalDateTime saleDate,String payment, Member member, Product product) {
        this.saleQuantity = saleQuantity;
        this.salePrice = salePrice;
        this.saleDate = saleDate;
        this.member = member;
        this.product = product;
        this.payment = payment;
    }

    public static ProductSale createProductSale(Member member, Product product, Long saleQuantity, Long salePrice, LocalDateTime saleDate, String payment) {
        return new ProductSale(saleQuantity,salePrice,saleDate,payment,member,product);
    }
}
