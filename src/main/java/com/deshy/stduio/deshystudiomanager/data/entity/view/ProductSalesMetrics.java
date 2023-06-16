package com.deshy.stduio.deshystudiomanager.data.entity.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.time.LocalDateTime;

@Entity
@Immutable
@Subselect("SELECT DATE_TRUNC('hour',ps.sale_date) AS sale_date, " +
        "SUM(ps.sale_quantity) AS sales_volume, " +
        "SUM(ps.sale_quantity * (ps.sale_price - p.origin_price)) AS profit, " +
        "SUM(ps.sale_quantity * ps.sale_price) AS revenue " +
        "FROM product_sale ps JOIN product p ON ps.product_id = p.product_id GROUP BY DATE_TRUNC('hour', ps.sale_date)")
@Getter
public class ProductSalesMetrics {

    @Id
    private LocalDateTime saleDate;
    private Long salesVolume;
    private Long profit;
    private Long revenue;

}
