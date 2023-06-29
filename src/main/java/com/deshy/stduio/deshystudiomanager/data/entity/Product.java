package com.deshy.stduio.deshystudiomanager.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "product")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_size_id")
    private ProductSize size;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory category;

    @Column(name = "origin_price", nullable = false)
    private Long originPrice;

    @Column(name = "stock_quantity", nullable = false)
    private Long stockQuantity;

    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    protected Product(String name, ProductSize size, ProductCategory category, Long originPrice, Long stockQuantity, LocalDate purchaseDate, Member member, Vendor vendor) {
        this.name = name;
        this.size = size;
        this.category = category;
        this.originPrice = originPrice;
        this.stockQuantity = stockQuantity;
        this.purchaseDate = purchaseDate;
        this.member = member;
        this.vendor = vendor;
    }


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSale> productSales = new ArrayList<>();

    public static Product createProduct(String name, ProductSize size, ProductCategory category, Long originPrice, Long stockQuantity, LocalDate purchaseDate,Member member, Vendor vendor) {
        return new Product(name,size,category,originPrice,stockQuantity,purchaseDate,member,vendor);
    }

}
