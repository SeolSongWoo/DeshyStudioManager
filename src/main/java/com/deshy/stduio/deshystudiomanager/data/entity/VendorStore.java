package com.deshy.stduio.deshystudiomanager.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vendor_store")
@Getter
@NoArgsConstructor
public class VendorStore {
    @Id
    @GeneratedValue
    private Long vendorStoreId;

    @Column(name = "store", nullable = false, unique = true)
    private String store;

    @OneToMany(mappedBy = "store")
    private List<Vendor> vendors = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private UUID uid = UUID.randomUUID();

    protected VendorStore(String store, Member member) {
        this.store = store;
        this.member = member;
    }

    public static VendorStore create(String store, Member member) {
        return new VendorStore(store,member);
    }
}
