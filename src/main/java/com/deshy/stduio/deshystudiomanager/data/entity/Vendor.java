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
}
