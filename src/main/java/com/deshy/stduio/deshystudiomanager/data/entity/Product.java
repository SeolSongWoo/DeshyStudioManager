package com.deshy.stduio.deshystudiomanager.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "origin_price", nullable = false)
    private Long originPrice;

    @Column(name = "stock_quantity", nullable = false)
    private Long stockQuantity;

    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSale> productSales = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
}
