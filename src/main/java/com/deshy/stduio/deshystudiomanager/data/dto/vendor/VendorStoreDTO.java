package com.deshy.stduio.deshystudiomanager.data.dto.vendor;

import com.deshy.stduio.deshystudiomanager.data.dto.product.CategoryDTO;
import com.deshy.stduio.deshystudiomanager.data.entity.ProductCategory;
import com.deshy.stduio.deshystudiomanager.data.entity.VendorStore;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class VendorStoreDTO {
    private String name;
    private UUID uid;

    public static VendorStoreDTO of(VendorStore vendorStore) {
        return VendorStoreDTO.builder()
                .name(vendorStore.getStore())
                .uid(vendorStore.getUid())
                .build();
    }

    public static List<VendorStoreDTO> ofList(List<VendorStore> vendorStores) {
        return vendorStores.stream().map(VendorStoreDTO::of).toList();
    }
}
