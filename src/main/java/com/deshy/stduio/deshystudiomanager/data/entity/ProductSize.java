package com.deshy.stduio.deshystudiomanager.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "product_size")
public class ProductSize {

    @Id
    @GeneratedValue
    private Long ProductSizeId;

    private String size;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory category;

    @OneToMany(mappedBy = "size")
    private List<Product> products = new ArrayList<>();
}
