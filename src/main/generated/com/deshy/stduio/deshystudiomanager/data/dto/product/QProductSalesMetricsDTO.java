package com.deshy.stduio.deshystudiomanager.data.dto.product;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.deshy.stduio.deshystudiomanager.data.dto.product.QProductSalesMetricsDTO is a Querydsl Projection type for ProductSalesMetricsDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QProductSalesMetricsDTO extends ConstructorExpression<ProductSalesMetricsDTO> {

    private static final long serialVersionUID = -1886586417L;

    public QProductSalesMetricsDTO(com.querydsl.core.types.Expression<java.time.LocalDateTime> salesDate, com.querydsl.core.types.Expression<Long> volume, com.querydsl.core.types.Expression<Long> profit, com.querydsl.core.types.Expression<Long> revenue) {
        super(ProductSalesMetricsDTO.class, new Class<?>[]{java.time.LocalDateTime.class, long.class, long.class, long.class}, salesDate, volume, profit, revenue);
    }

    public QProductSalesMetricsDTO(com.querydsl.core.types.Expression<Long> volume, com.querydsl.core.types.Expression<Long> profit, com.querydsl.core.types.Expression<Long> revenue) {
        super(ProductSalesMetricsDTO.class, new Class<?>[]{long.class, long.class, long.class}, volume, profit, revenue);
    }

}

