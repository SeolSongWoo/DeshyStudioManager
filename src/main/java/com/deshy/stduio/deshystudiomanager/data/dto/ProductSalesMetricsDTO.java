package com.deshy.stduio.deshystudiomanager.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSalesMetricsDTO {
    private LocalDateTime salesDate;
    private Long volume;
    private Long profit;
    private Long revenue;

    @QueryProjection
    public ProductSalesMetricsDTO(LocalDateTime salesDate, Long volume, Long profit, Long revenue) {
        this.salesDate = salesDate;
        this.volume = volume;
        this.profit = profit;
        this.revenue = revenue;
    }

    @QueryProjection
    public ProductSalesMetricsDTO(Long volume, Long profit, Long revenue) {
        this.volume = volume;
        this.profit = profit;
        this.revenue = revenue;
    }
}
