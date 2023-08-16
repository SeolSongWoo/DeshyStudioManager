package com.deshy.stduio.deshystudiomanager.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductSale is a Querydsl query type for ProductSale
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductSale extends EntityPathBase<ProductSale> {

    private static final long serialVersionUID = -486606669L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductSale productSale = new QProductSale("productSale");

    public final QMember member;

    public final QProduct product;

    public final NumberPath<Long> productSaleId = createNumber("productSaleId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> saleDate = createDateTime("saleDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> salePrice = createNumber("salePrice", Long.class);

    public final NumberPath<Long> saleQuantity = createNumber("saleQuantity", Long.class);

    public final ComparablePath<java.util.UUID> uid = createComparable("uid", java.util.UUID.class);

    public QProductSale(String variable) {
        this(ProductSale.class, forVariable(variable), INITS);
    }

    public QProductSale(Path<? extends ProductSale> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductSale(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductSale(PathMetadata metadata, PathInits inits) {
        this(ProductSale.class, metadata, inits);
    }

    public QProductSale(Class<? extends ProductSale> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

