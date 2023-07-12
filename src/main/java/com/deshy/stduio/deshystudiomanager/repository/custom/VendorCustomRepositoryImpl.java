package com.deshy.stduio.deshystudiomanager.repository.custom;

import com.deshy.stduio.deshystudiomanager.data.dto.vendor.VendorSalesDTO;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.deshy.stduio.deshystudiomanager.data.entity.QProduct.product;
import static com.deshy.stduio.deshystudiomanager.data.entity.QProductSale.productSale;
import static com.deshy.stduio.deshystudiomanager.data.entity.QVendor.vendor;

@RequiredArgsConstructor
@Repository
public class VendorCustomRepositoryImpl implements VendorCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<VendorSalesDTO> findTopVolumeVendorsByLimit(Long limit) {
        return findTopVendorsByLimit(limit, productSale.saleQuantity.sum().desc());
    }

    @Override
    public List<VendorSalesDTO> findTopRevenueVendorsByLimit(Long limit) {
        return findTopVendorsByLimit(limit, productSale.saleQuantity.multiply(productSale.salePrice).sum().desc());
    }

    @Override
    public List<VendorSalesDTO> findTopProfitVendorsByLimit(Long limit) {
        return findTopVendorsByLimit(limit, productSale.saleQuantity.multiply(productSale.salePrice.subtract(product.originPrice)).sum().desc());
    }

    private List<VendorSalesDTO> findTopVendorsByLimit(Long limit, OrderSpecifier<?> orderSpecifier) {
        return jpaQueryFactory.select(Projections.bean(VendorSalesDTO.class,
                        vendor.name.as("vendorName"),
                        productSale.saleQuantity.sum().as("totalVolume"),
                        productSale.saleQuantity.multiply(productSale.salePrice).sum().as("totalRevenue"),
                        productSale.saleQuantity.multiply(productSale.salePrice.subtract(product.originPrice)).sum().as("totalProfit")
                ))
                .from(productSale)
                .join(productSale.product, product)
                .join(product.vendor,vendor)
                .groupBy(vendor.vendorId,vendor.name)
                .orderBy(orderSpecifier)
                .limit(limit)
                .fetch();
    }
}
