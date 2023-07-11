package com.deshy.stduio.deshystudiomanager.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVendorStore is a Querydsl query type for VendorStore
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVendorStore extends EntityPathBase<VendorStore> {

    private static final long serialVersionUID = 1053652822L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVendorStore vendorStore = new QVendorStore("vendorStore");

    public final QMember member;

    public final StringPath store = createString("store");

    public final ComparablePath<java.util.UUID> uid = createComparable("uid", java.util.UUID.class);

    public final ListPath<Vendor, QVendor> vendors = this.<Vendor, QVendor>createList("vendors", Vendor.class, QVendor.class, PathInits.DIRECT2);

    public final NumberPath<Long> vendorStoreId = createNumber("vendorStoreId", Long.class);

    public QVendorStore(String variable) {
        this(VendorStore.class, forVariable(variable), INITS);
    }

    public QVendorStore(Path<? extends VendorStore> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVendorStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVendorStore(PathMetadata metadata, PathInits inits) {
        this(VendorStore.class, metadata, inits);
    }

    public QVendorStore(Class<? extends VendorStore> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

