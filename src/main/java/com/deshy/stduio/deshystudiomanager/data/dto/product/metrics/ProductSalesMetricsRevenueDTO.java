package com.deshy.stduio.deshystudiomanager.data.dto.product.metrics;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductSalesMetricsRevenueDTO {
    LocalDateTime getSaleDate();
    Long getRevenue();

}
