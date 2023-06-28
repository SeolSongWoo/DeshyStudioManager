package com.deshy.stduio.deshystudiomanager.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @GeneratedValue
    private Long productCategoryId;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<ProductSize> sizes = new ArrayList<>();
}
