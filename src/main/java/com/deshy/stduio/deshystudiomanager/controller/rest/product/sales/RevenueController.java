package com.deshy.stduio.deshystudiomanager.controller.rest.product.sales;

import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.data.dto.ProductSalesMetricsDTO;
import com.deshy.stduio.deshystudiomanager.service.product.metrics.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/products/metrics/revenue")
@RestController
@RequiredArgsConstructor
public class RevenueController {
    private final RevenueService revenueService;


    @GetMapping
    public ResponseEntity<CommonResponse<Long>> getTotalRevenue() {
        return new ResponseEntity<>(CommonResponse.success(revenueService.getTotalRevenue(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/today")
    public ResponseEntity<CommonResponse<Long>> getTotalRevenueToday() {
        return new ResponseEntity<>(CommonResponse.success(revenueService.getTodayRevenue(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/today/hour")
    public ResponseEntity<CommonResponse<List<ProductSalesMetricsDTO>>> getTotalRevenueTodayByHour() {
        return new ResponseEntity<>(CommonResponse.success(revenueService.getTodayRevenueByHour(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/month")
    public ResponseEntity<CommonResponse<Long>> getTotalRevenueThisMonth() {
        return new ResponseEntity<>(CommonResponse.success(revenueService.getMonthRevenue(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/month/day")
    public ResponseEntity<CommonResponse<List<ProductSalesMetricsDTO>>> getTotalRevenueThisMonthByHour() {
        return new ResponseEntity<>(CommonResponse.success(revenueService.getMonthRevenueByDay(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/year")
    public ResponseEntity<CommonResponse<Long>> getTotalRevenueThisYear() {
        return new ResponseEntity<>(CommonResponse.success(revenueService.getYearRevenue(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/year/month")
    public ResponseEntity<CommonResponse<List<ProductSalesMetricsDTO>>> getTotalRevenueThisYearByHour() {
        return new ResponseEntity<>(CommonResponse.success(revenueService.getYearRevenueByMonth(), CommonCode.FOUND_OK), HttpStatus.OK);
    }
}