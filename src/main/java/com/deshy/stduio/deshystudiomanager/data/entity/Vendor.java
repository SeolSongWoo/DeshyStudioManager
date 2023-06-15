package com.deshy.stduio.deshystudiomanager.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "vendor")
@Getter
public class Vendor {
    @Id
    @GeneratedValue
    private Long vendorId;
    private String name;
    private String phone;
    private String email;
    private String description;
    private String arcade;
    private Long floor;
    private String row;
    private String suite;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}