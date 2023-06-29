package com.deshy.stduio.deshystudiomanager.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVendor is a Querydsl query type for Vendor
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVendor extends EntityPathBase<Vendor> {

    private static final long serialVersionUID = 899352651L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVendor vendor = new QVendor("vendor");

    public final StringPath arcade = createString("arcade");

    public final StringPath description = createString("description");

    public final StringPath email = createString("email");

    public final NumberPath<Long> floor = createNumber("floor", Long.class);

    public final QMember member;

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final ListPath<Product, QProduct> products = this.<Product, QProduct>createList("products", Product.class, QProduct.class, PathInits.DIRECT2);

    public final StringPath row = createString("row");

    public final StringPath suite = createString("suite");

    public final ComparablePath<java.util.UUID> uid = createComparable("uid", java.util.UUID.class);

    public final NumberPath<Long> vendorId = createNumber("vendorId", Long.class);

    public QVendor(String variable) {
        this(Vendor.class, forVariable(variable), INITS);
    }

    public QVendor(Path<? extends Vendor> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVendor(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVendor(PathMetadata metadata, PathInits inits) {
        this(Vendor.class, metadata, inits);
    }

    public QVendor(Class<? extends Vendor> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

