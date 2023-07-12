package com.deshy.stduio.deshystudiomanager.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vendor")
@Getter
@NoArgsConstructor
public class Vendor {
    @Id
    @GeneratedValue
    private Long vendorId;
    private String name;
    private String phone;
    private String email;
    private String description;
    private Long floor;
    private String row;
    private String suite;
    @ManyToOne
    @JoinColumn(name = "vendor_store_id")
    private VendorStore store;

    private UUID uid = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    protected Vendor(String name, String phone, String email, String description, Long floor, String row, String suite, VendorStore store, Member member) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.floor = floor;
        this.row = row;
        this.suite = suite;
        this.store = store;
        this.member = member;
    }

    public static Vendor create(String name, String phone, String email, String description, Long floor, String row, String suite, VendorStore vendorStore, Member member) {
        return new Vendor(name,phone,email,description,floor,row,suite,vendorStore,member);
    }
}
