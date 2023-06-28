package com.deshy.stduio.deshystudiomanager.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "product_style")
public class ProductCategory {
    @Id
    @GeneratedValue
    private Long productStyleId;

    @
}
