package com.deshy.stduio.deshystudiomanager.data.dto.vendor;

import com.deshy.stduio.deshystudiomanager.data.entity.Vendor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class VendorDTO {
    private String name;
    private UUID store;
    private String email;
    private String phone;
    private Long floor;
    private String row;
    private String suite;
    private String description;

    public static VendorDTO of(Vendor vendor) {
        return VendorDTO.builder()
                .name(vendor.getName())
                .store(vendor.getUid())
                .email(vendor.getEmail())
                .phone(vendor.getPhone())
                .floor(vendor.getFloor())
                .row(vendor.getRow())
                .suite(vendor.getSuite())
                .description(vendor.getDescription()).build();
    }

    public static List<VendorDTO> ofList(List<Vendor> vendors) {
        return vendors.stream().map(VendorDTO::of).toList();
    }
}
