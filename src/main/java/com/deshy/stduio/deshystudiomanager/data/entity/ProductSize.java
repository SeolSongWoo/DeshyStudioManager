package com.deshy.stduio.deshystudiomanager.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Table(name = "product_size")
@NoArgsConstructor
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

    private UUID uid = UUID.randomUUID();
    protected ProductSize(ProductCategory category, String sizeName) {
        this.size = sizeName;
        this.category = category;
    }
    public static ProductSize create(ProductCategory category, String sizeName) {
        return new ProductSize(category,sizeName);
    }
}
