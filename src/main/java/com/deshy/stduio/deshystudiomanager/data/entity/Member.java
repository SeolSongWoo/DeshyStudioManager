package com.deshy.stduio.deshystudiomanager.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor
public class Member {

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

    public Member(Long memberId, String name, String id, String password, String email, String phone, String role) {
        this.memberId = memberId;
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public static Member createMember(String memberName, String memberId, String memberPassword, String memberEmail, String memberPhone, PasswordEncoder passwordEncoder) {
        return new Member(null,memberName, memberId, passwordEncoder.encode(memberPassword), memberEmail, memberPhone, "USER");
    }
}
