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

    @Column(name = "size", nullable = false)
    private Long size;

    @OneToMany(mappedBy = "product_size", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();
}
