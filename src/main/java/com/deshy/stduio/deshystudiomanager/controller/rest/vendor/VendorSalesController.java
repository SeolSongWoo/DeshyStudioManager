package com.deshy.stduio.deshystudiomanager.controller.rest.vendor;

import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.data.dto.vendor.VendorSalesDTO;
import com.deshy.stduio.deshystudiomanager.service.VendorSalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vendor/sales")
@RequiredArgsConstructor
public class VendorSalesController {
    private final VendorSalesService vendorSalesService;
    @GetMapping("/volume/{limit}")
    public ResponseEntity<CommonResponse<List<VendorSalesDTO>>> getTopVolumeVendorsByLimits(@PathVariable Long limit) {
        return new ResponseEntity<>(CommonResponse.success(vendorSalesService.getTopVolumeVendorsByLimits(limit), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/revenue/{limit}")
    public ResponseEntity<CommonResponse<List<VendorSalesDTO>>> getTopRevenueVendorsByLimits(@PathVariable Long limit) {
        return new ResponseEntity<>(CommonResponse.success(vendorSalesService.getTopRevenueVendorsByLimits(limit), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/profit/{limit}")
    public ResponseEntity<CommonResponse<List<VendorSalesDTO>>> getTopProfitVendorsByLimits(@PathVariable Long limit) {
        return new ResponseEntity<>(CommonResponse.success(vendorSalesService.getTopProfitVendorsByLimits(limit), CommonCode.FOUND_OK), HttpStatus.OK);
    }
}
