package com.deshy.stduio.deshystudiomanager.data.dto.vendor;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class VendorDTO {
    private String name;
    private UUID store;
    private String email;
    private String phone;
    private String floor;
    private String row;
    private String suite;
    private String memo;
}
