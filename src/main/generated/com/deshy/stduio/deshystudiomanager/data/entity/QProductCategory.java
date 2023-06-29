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

    public static final QProductCategory productCategory = new QProductCategory("productCategory");

    public final StringPath category = createString("category");

    public final NumberPath<Long> productCategoryId = createNumber("productCategoryId", Long.class);

    public final ListPath<Product, QProduct> products = this.<Product, QProduct>createList("products", Product.class, QProduct.class, PathInits.DIRECT2);

    public final ListPath<ProductSize, QProductSize> sizes = this.<ProductSize, QProductSize>createList("sizes", ProductSize.class, QProductSize.class, PathInits.DIRECT2);

    public QProductCategory(String variable) {
        super(ProductCategory.class, forVariable(variable));
    }

    public QProductCategory(Path<? extends ProductCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductCategory(PathMetadata metadata) {
        super(ProductCategory.class, metadata);
    }

}

