package com.deshy.stduio.deshystudiomanager.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 641658269L;

    public static final QMember member = new QMember("member1");

    public final ListPath<ProductCategory, QProductCategory> categories = this.<ProductCategory, QProductCategory>createList("categories", ProductCategory.class, QProductCategory.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final StringPath id = createString("id");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final ListPath<Product, QProduct> products = this.<Product, QProduct>createList("products", Product.class, QProduct.class, PathInits.DIRECT2);

    public final ListPath<ProductSale, QProductSale> productSales = this.<ProductSale, QProductSale>createList("productSales", ProductSale.class, QProductSale.class, PathInits.DIRECT2);

    public final StringPath role = createString("role");

    public final ListPath<ProductSize, QProductSize> sizes = this.<ProductSize, QProductSize>createList("sizes", ProductSize.class, QProductSize.class, PathInits.DIRECT2);

    public final ListPath<Vendor, QVendor> vendors = this.<Vendor, QVendor>createList("vendors", Vendor.class, QVendor.class, PathInits.DIRECT2);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

