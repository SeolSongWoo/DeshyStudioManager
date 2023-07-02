package com.deshy.stduio.deshystudiomanager.repository;

import com.deshy.stduio.deshystudiomanager.data.entity.ProductSale;
import com.deshy.stduio.deshystudiomanager.repository.custom.ProductSalesMetricsCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSaleRepository extends JpaRepository<ProductSale, Long>, ProductSalesMetricsCustomRepository {

    Page<ProductSale> findAll(Pageable pageable);
}
