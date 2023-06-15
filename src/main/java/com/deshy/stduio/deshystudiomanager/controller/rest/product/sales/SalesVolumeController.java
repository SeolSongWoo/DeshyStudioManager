package com.deshy.stduio.deshystudiomanager.controller.rest.product.sales;

import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.service.product.sales.SalesVolumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/products/sales/volume")
@RestController
@RequiredArgsConstructor
public class SalesVolumeController {
    private final SalesVolumeService salesVolumeService;

    @GetMapping
    public ResponseEntity<CommonResponse<Long>> getTotalSales() {
        return new ResponseEntity<>(CommonResponse.success(salesVolumeService.getTotalSalesVolume(), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<CommonResponse<Long>> getTotalSalesByProduct(@PathVariable Long productId) {
        return new ResponseEntity<>(CommonResponse.success(salesVolumeService.getSalesVolumeByProduct(productId), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }

    @GetMapping("/today")
    public ResponseEntity<CommonResponse<Long>> getTotalSalesToday() {
        return new ResponseEntity<>(CommonResponse.success(salesVolumeService.getTodaySalesVolume(), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }

    @GetMapping("/month")
    public ResponseEntity<CommonResponse<Long>> getTotalSalesThisMonth() {
        return new ResponseEntity<>(CommonResponse.success(salesVolumeService.getMonthSalesVolume(), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }

    @GetMapping("/year")
    public ResponseEntity<CommonResponse<Long>> getTotalSalesThisYear() {
        return new ResponseEntity<>(CommonResponse.success(salesVolumeService.getYearSalesVolume(), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }
}