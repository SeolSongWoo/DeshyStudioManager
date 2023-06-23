package com.deshy.stduio.deshystudiomanager.controller.rest.product.sales;

import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.data.dto.ProductSalesMetricsDTO;
import com.deshy.stduio.deshystudiomanager.service.product.metrics.VolumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/products/metrics/volume")
@RestController
@RequiredArgsConstructor
public class VolumeController {
    private final VolumeService VolumeService;

    @GetMapping
    public ResponseEntity<CommonResponse<Long>> getTotalSales() {
        return new ResponseEntity<>(CommonResponse.success(VolumeService.getTotalVolume(), CommonCode.FOUND_OK), HttpStatus.OK);
    }
    @GetMapping("/today")
    public ResponseEntity<CommonResponse<Long>> getTotalSalesToday() {
        return new ResponseEntity<>(CommonResponse.success(VolumeService.getTodayVolume(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/today/hour")
    public ResponseEntity<CommonResponse<List<ProductSalesMetricsDTO>>> getTotalSalesTodayByHour() {
        return new ResponseEntity<>(CommonResponse.success(VolumeService.getTodayVolumeByHour(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/month")
    public ResponseEntity<CommonResponse<Long>> getTotalSalesThisMonth() {
        return new ResponseEntity<>(CommonResponse.success(VolumeService.getMonthVolume(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/month/day")
    public ResponseEntity<CommonResponse<List<ProductSalesMetricsDTO>>> getTotalSalesThisMonthByHour() {
        return new ResponseEntity<>(CommonResponse.success(VolumeService.getMonthVolumeByDay(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/year")
    public ResponseEntity<CommonResponse<Long>> getTotalSalesThisYear() {
        return new ResponseEntity<>(CommonResponse.success(VolumeService.getYearVolume(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/year/month")
    public ResponseEntity<CommonResponse<List<ProductSalesMetricsDTO>>> getTotalSalesThisYearByHour() {
        return new ResponseEntity<>(CommonResponse.success(VolumeService.getYearVolumeByMonth(), CommonCode.FOUND_OK), HttpStatus.OK);
    }
}