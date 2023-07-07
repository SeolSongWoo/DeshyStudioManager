package com.deshy.stduio.deshystudiomanager.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Table(name = "product_category")
@NoArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue
    private Long productCategoryId;

    @Column(name = "category", nullable = false, unique = true)
    private String category;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private List<ProductSize> sizes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private UUID uid = UUID.randomUUID();

    protected ProductCategory(String category, Member member) {
        this.category = category;
        this.member = member;
    }

    public static ProductCategory create(String category, Member member) {
        return new ProductCategory(category,member);
    }
}
