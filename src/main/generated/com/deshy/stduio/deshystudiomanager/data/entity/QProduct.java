package com.deshy.stduio.deshystudiomanager.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 1453181516L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final QProductCategory category;

    public final QMember member;

    public final StringPath name = createString("name");

    public final NumberPath<Long> originPrice = createNumber("originPrice", Long.class);

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public final ListPath<ProductSale, QProductSale> productSales = this.<ProductSale, QProductSale>createList("productSales", ProductSale.class, QProductSale.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> purchaseDate = createDate("purchaseDate", java.time.LocalDate.class);

    public final QProductSize size;

    public final NumberPath<Long> stockQuantity = createNumber("stockQuantity", Long.class);

    public final ComparablePath<java.util.UUID> uid = createComparable("uid", java.util.UUID.class);

    public final QVendor vendor;

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QProductCategory(forProperty("category"), inits.get("category")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
        this.size = inits.isInitialized("size") ? new QProductSize(forProperty("size"), inits.get("size")) : null;
        this.vendor = inits.isInitialized("vendor") ? new QVendor(forProperty("vendor"), inits.get("vendor")) : null;
    }

}

