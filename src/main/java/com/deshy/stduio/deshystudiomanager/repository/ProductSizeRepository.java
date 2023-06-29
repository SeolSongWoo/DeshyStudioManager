package com.deshy.stduio.deshystudiomanager.repository;

import com.deshy.stduio.deshystudiomanager.data.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {
    Optional<ProductSize> findBySize(String size);
}
