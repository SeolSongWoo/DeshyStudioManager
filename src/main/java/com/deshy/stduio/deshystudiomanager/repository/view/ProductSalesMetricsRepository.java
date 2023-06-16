package com.deshy.stduio.deshystudiomanager.repository.view;

import com.deshy.stduio.deshystudiomanager.data.dto.product.metrics.ProductSalesMetricsProfitDTO;
import com.deshy.stduio.deshystudiomanager.data.dto.product.metrics.ProductSalesMetricsRevenueDTO;
import com.deshy.stduio.deshystudiomanager.data.dto.product.metrics.ProductSalesMetricsSalesVolumeDTO;
import com.deshy.stduio.deshystudiomanager.data.entity.view.ProductSalesMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductSalesMetricsRepository extends JpaRepository<ProductSalesMetrics, Long> {

    @Query("SELECT psm FROM ProductSalesMetrics psm WHERE psm.saleDate >= :startDate AND psm.saleDate < :endDate ORDER BY psm.saleDate")
    List<ProductSalesMetricsProfitDTO> findProfitBetweenDatesOrderBySaleDate(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT psm FROM ProductSalesMetrics psm WHERE psm.saleDate >= :startDate AND psm.saleDate < :endDate ORDER BY psm.saleDate")
    List<ProductSalesMetricsSalesVolumeDTO> findSalesVolumeBetweenDatesOrderBySaleDate(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT psm FROM ProductSalesMetrics psm WHERE psm.saleDate >= :startDate AND psm.saleDate < :endDate ORDER BY psm.saleDate")
    List<ProductSalesMetricsRevenueDTO> findRevenueBetweenDatesOrderBySaleDate(LocalDateTime startDate, LocalDateTime endDate);
}
