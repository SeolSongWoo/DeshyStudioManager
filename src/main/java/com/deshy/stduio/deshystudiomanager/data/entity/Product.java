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
    private String name;
    private String type;
    private String size;
    private Long originPrice;
    private Long stockQuantity;
    private LocalDate purchaseDate;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSale> productSales = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
