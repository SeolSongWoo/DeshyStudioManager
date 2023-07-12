package com.deshy.stduio.deshystudiomanager.data.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {

    @Id
    @GeneratedValue
    private Long memberId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "role", nullable = false)
    private String role;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Product> products = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<ProductSale> productSales = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Vendor> vendors = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<ProductCategory> categories = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<VendorStore> vendorStores = new ArrayList<>();

    public Member(String name, String id, String password, String email, String phone, String role) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public static Member createMember(String memberName, String memberId, String memberPassword, String memberEmail, String memberPhone, PasswordEncoder passwordEncoder) {
        return new Member(memberName, memberId, passwordEncoder.encode(memberPassword), memberEmail, memberPhone, "USER");
    }
}
