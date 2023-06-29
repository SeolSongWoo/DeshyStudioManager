package com.deshy.stduio.deshystudiomanager.repository;

import com.deshy.stduio.deshystudiomanager.data.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {

    Optional<ProductCategory> findByCategory(String category);
}
