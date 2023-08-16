package com.deshy.stduio.deshystudiomanager.repository;

import com.deshy.stduio.deshystudiomanager.data.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {
    Optional<ProductSize> findByUid(UUID uid);

    @Query("SELECT ps FROM ProductSize ps JOIN FETCH ps.category c WHERE c.uid = :categoryUid")
    List<ProductSize> findByCategoryUid(@Param("categoryUid") UUID categoryUid);
}
