package com.deshy.stduio.deshystudiomanager.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductCategory is a Querydsl query type for ProductCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductCategory extends EntityPathBase<ProductCategory> {

    private static final long serialVersionUID = 1952571242L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductCategory productCategory = new QProductCategory("productCategory");

    public final StringPath category = createString("category");

    public final QMember member;

    public final NumberPath<Long> productCategoryId = createNumber("productCategoryId", Long.class);

    public final ListPath<Product, QProduct> products = this.<Product, QProduct>createList("products", Product.class, QProduct.class, PathInits.DIRECT2);

    public final ListPath<ProductSize, QProductSize> sizes = this.<ProductSize, QProductSize>createList("sizes", ProductSize.class, QProductSize.class, PathInits.DIRECT2);

    public final ComparablePath<java.util.UUID> uid = createComparable("uid", java.util.UUID.class);

    public QProductCategory(String variable) {
        this(ProductCategory.class, forVariable(variable), INITS);
    }

    public QProductCategory(Path<? extends ProductCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductCategory(PathMetadata metadata, PathInits inits) {
        this(ProductCategory.class, metadata, inits);
    }

    public QProductCategory(Class<? extends ProductCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

