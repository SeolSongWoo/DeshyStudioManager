package com.deshy.stduio.deshystudiomanager.repository.custom;

import com.deshy.stduio.deshystudiomanager.data.dto.product.ProductSalesMetricsDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductSalesMetricsCustomRepository {
    List<ProductSalesMetricsDTO> findProfitBetweenDatesByDateTrunc(LocalDateTime startDate, LocalDateTime endDate,String dateTruncUnit);

    Long findTotalProfit();

    Long findTotalProfitBetweenDates(LocalDateTime startDate, LocalDateTime endDate);

    List<ProductSalesMetricsDTO> findRevenueBetweenDatesByDateTrunc(LocalDateTime startDate, LocalDateTime endDate,String dateTruncUnit);

    Long findTotalRevenue();

    Long findTotalRevenueBetweenDates(LocalDateTime startDate, LocalDateTime endDate);

    List<ProductSalesMetricsDTO> findVolumeBetweenDatesByDateTrunc(LocalDateTime startDate, LocalDateTime endDate,String dateTruncUnit);

    Long findTotalVolume();

    Long findTotalVolumeBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
}
