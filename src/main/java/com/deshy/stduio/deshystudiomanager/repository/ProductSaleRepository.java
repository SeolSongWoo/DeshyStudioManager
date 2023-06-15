package com.deshy.stduio.deshystudiomanager.repository;

import com.deshy.stduio.deshystudiomanager.data.entity.ProductSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductSaleRepository extends JpaRepository<ProductSale, Long> {

    //총 판매량
    @Query("SELECT SUM(ps.saleQuantity) FROM ProductSale ps WHERE ps.product.productId = :productId")
    Optional<Long> findSalesVolumeByProductId(@Param("productId") Long productId);

    //총 판매액
    @Query("SELECT SUM(ps.saleQuantity) FROM ProductSale ps")
    Optional<Long> findTotalSalesVolume();

    //총 순수익
    @Query("SELECT SUM(ps.saleQuantity * ps.product.originPrice) FROM ProductSale ps")
    Optional<Long> findTotalRevenue();

    @Query("SELECT SUM(ps.saleQuantity * (ps.salePrice - ps.product.originPrice)) FROM ProductSale ps")
    Optional<Long> findTotalProfit();

    //특정 기간 동안의 판매량
    @Query("SELECT SUM(s.saleQuantity) FROM ProductSale s WHERE s.saleDate >= :startDate AND s.saleDate < :endDate")
    Optional<Long> findSalesVolumeBetweenDates(LocalDateTime startDate, LocalDateTime endDate);

    //특정 기간 동안의 판매액
    @Query("SELECT SUM(s.saleQuantity * s.product.originPrice) FROM ProductSale s WHERE s.saleDate >= :startDate AND s.saleDate < :endDate")
    Optional<Long> findRevenueBetweenDates(LocalDateTime startDate, LocalDateTime endDate);

    //특정 기간 동안의 순수익
    @Query("SELECT SUM(s.saleQuantity * (s.salePrice - s.product.originPrice)) FROM ProductSale s WHERE s.saleDate >= :startDate AND s.saleDate < :endDate")
    Optional<Long> findProfitBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
}
