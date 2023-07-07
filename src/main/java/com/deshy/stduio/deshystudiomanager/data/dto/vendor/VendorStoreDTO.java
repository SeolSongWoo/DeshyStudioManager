package com.deshy.stduio.deshystudiomanager.data.dto.vendor;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class VendorStoreDTO {
    private String name;
    private UUID uid;
}
