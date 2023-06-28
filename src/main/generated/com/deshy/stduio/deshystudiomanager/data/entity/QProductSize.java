package com.deshy.stduio.deshystudiomanager.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductSize is a Querydsl query type for ProductSize
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductSize extends EntityPathBase<ProductSize> {

    private static final long serialVersionUID = -486598547L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductSize productSize = new QProductSize("productSize");

    public final QProductCategory category;

    public final ListPath<Product, QProduct> products = this.<Product, QProduct>createList("products", Product.class, QProduct.class, PathInits.DIRECT2);

    public final NumberPath<Long> ProductSizeId = createNumber("ProductSizeId", Long.class);

    public final StringPath size = createString("size");

    public QProductSize(String variable) {
        this(ProductSize.class, forVariable(variable), INITS);
    }

    public QProductSize(Path<? extends ProductSize> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductSize(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductSize(PathMetadata metadata, PathInits inits) {
        this(ProductSize.class, metadata, inits);
    }

    public QProductSize(Class<? extends ProductSize> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QProductCategory(forProperty("category")) : null;
    }

}

