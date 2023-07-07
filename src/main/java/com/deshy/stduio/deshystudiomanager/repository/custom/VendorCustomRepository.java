package com.deshy.stduio.deshystudiomanager.repository.custom;

import com.deshy.stduio.deshystudiomanager.data.dto.vendor.VendorSalesDTO;

import java.util.List;

public interface VendorCustomRepository {
    List<VendorSalesDTO> findTopVolumeVendorsByLimit(Long limit);

    List<VendorSalesDTO> findTopRevenueVendorsByLimit(Long limit);
    List<VendorSalesDTO> findTopProfitVendorsByLimit(Long limit);
}
