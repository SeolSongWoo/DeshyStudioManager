package com.deshy.stduio.deshystudiomanager.data.dto.product.metrics;

import com.deshy.stduio.deshystudiomanager.data.entity.view.ProductSalesMetrics;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


public interface ProductSalesMetricsProfitDTO{
    LocalDateTime getSaleDate();
    Long getProfit();

}
