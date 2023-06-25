package com.deshy.stduio.deshystudiomanager.service;

import com.deshy.stduio.deshystudiomanager.data.dto.VendorSalesDTO;
import com.deshy.stduio.deshystudiomanager.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorSalesService {
    private final VendorRepository vendorRepository;

    public List<VendorSalesDTO> getTopVolumeVendorsByLimits(Long limit) {
        return vendorRepository.findTopVolumeVendorsByLimit(limit);
    }

    public List<VendorSalesDTO> getTopRevenueVendorsByLimits(Long limit) {
        return vendorRepository.findTopRevenueVendorsByLimit(limit);
    }

    public List<VendorSalesDTO> getTopProfitVendorsByLimits(Long limit) {
        return vendorRepository.findTopProfitVendorsByLimit(limit);
    }
}
