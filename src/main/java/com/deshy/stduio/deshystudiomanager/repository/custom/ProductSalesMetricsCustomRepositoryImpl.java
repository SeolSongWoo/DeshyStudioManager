package com.deshy.stduio.deshystudiomanager.repository.custom;

import com.deshy.stduio.deshystudiomanager.data.dto.ProductSalesMetricsDTO;
import com.deshy.stduio.deshystudiomanager.data.dto.QProductSalesMetricsDTO;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.deshy.stduio.deshystudiomanager.data.entity.QProduct.product;
import static com.deshy.stduio.deshystudiomanager.data.entity.QProductSale.productSale;

@Repository
@RequiredArgsConstructor
public class ProductSalesMetricsCustomRepositoryImpl implements ProductSalesMetricsCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ProductSalesMetricsDTO> findProfitBetweenDatesByDateTrunc(LocalDateTime startDate, LocalDateTime endDate, String dateTruncUnit) {
        Expression<LocalDateTime> dateTrunc = Expressions.dateTemplate(LocalDateTime.class,
                "DATE_TRUNC('" + dateTruncUnit + "', {0})", productSale.saleDate);
        DateTimeExpression<LocalDateTime> salesDate = Expressions.asDateTime(dateTrunc).as("salesDate");
        return jpaQueryFactory
                .select(Projections.bean(ProductSalesMetricsDTO.class,
                        salesDate,
                        productSale.saleQuantity.multiply(productSale.salePrice.subtract(product.originPrice)).sum().as("profit")
                ))
                .from(productSale)
                .join(productSale.product, product)
                .where(productSale.saleDate.between(startDate, endDate))
                .groupBy(dateTrunc)
                .fetch();
    }

    @Override
    public Long findTotalProfit() {
        return jpaQueryFactory
                .select(
                        productSale.saleQuantity.multiply(productSale.salePrice.subtract(product.originPrice)).sum().coalesce(0L)
                )
                .from(productSale)
                .join(productSale.product, product)
                .fetchOne();
    }

    @Override
    public Long findTotalProfitBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        return jpaQueryFactory
                .select(
                        productSale.saleQuantity.multiply(productSale.salePrice.subtract(product.originPrice)).sum().coalesce(0L)
                )
                .from(productSale)
                .join(productSale.product, product)
                .where(productSale.saleDate.between(startDate, endDate))
                .fetchOne();
    }

    @Override
    public List<ProductSalesMetricsDTO> findRevenueBetweenDatesByDateTrunc(LocalDateTime startDate, LocalDateTime endDate, String dateTruncUnit) {
        Expression<LocalDateTime> dateTrunc = Expressions.dateTemplate(LocalDateTime.class,
                "DATE_TRUNC('" + dateTruncUnit + "', {0})", productSale.saleDate);
        DateTimeExpression<LocalDateTime> salesDate = Expressions.asDateTime(dateTrunc).as("salesDate");
        return jpaQueryFactory
                .select(Projections.bean(ProductSalesMetricsDTO.class,
                        salesDate,
                        productSale.saleQuantity.multiply(productSale.salePrice).sum().as("revenue")
                ))
                .from(productSale)
                .where(productSale.saleDate.between(startDate, endDate))
                .groupBy(dateTrunc)
                .fetch();
    }

    @Override
    public Long findTotalRevenue() {
        return jpaQueryFactory
                .select(
                        productSale.saleQuantity.multiply(productSale.salePrice).sum().coalesce(0L)
                )
                .from(productSale)
                .fetchOne();
    }

    @Override
    public Long findTotalRevenueBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        return jpaQueryFactory
                .select(
                        productSale.saleQuantity.multiply(productSale.salePrice).sum().coalesce(0L)
                )
                .from(productSale)
                .where(productSale.saleDate.between(startDate, endDate))
                .fetchOne();
    }

    @Override
    public List<ProductSalesMetricsDTO> findVolumeBetweenDatesByDateTrunc(LocalDateTime startDate, LocalDateTime endDate, String dateTruncUnit) {
        Expression<LocalDateTime> dateTrunc = Expressions.dateTemplate(LocalDateTime.class,
                "DATE_TRUNC('" + dateTruncUnit + "', {0})", productSale.saleDate);
        DateTimeExpression<LocalDateTime> salesDate = Expressions.asDateTime(dateTrunc).as("salesDate");

        return jpaQueryFactory
                .select(Projections.bean(ProductSalesMetricsDTO.class,
                        salesDate,
                        productSale.saleQuantity.sum().as("volume")
                ))
                .from(productSale)
                .where(productSale.saleDate.between(startDate, endDate))
                .groupBy(dateTrunc)
                .fetch();
    }

    @Override
    public Long findTotalVolume() {
        return jpaQueryFactory
                .select(
                        productSale.saleQuantity.sum().coalesce(0L)
                )
                .from(productSale)
                .fetchOne();
    }

    @Override
    public Long findTotalVolumeBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        return jpaQueryFactory
                .select(
                        productSale.saleQuantity.sum().coalesce(0L)
                )
                .from(productSale)
                .where(productSale.saleDate.between(startDate, endDate))
                .fetchOne();
    }
}