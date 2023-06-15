package com.deshy.stduio.deshystudiomanager.controller.rest.product.sales;

import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.service.product.sales.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/products/sales/revenue")
@RestController
@RequiredArgsConstructor
public class RevenueController {
    private final RevenueService revenueService;


    @GetMapping
    public ResponseEntity<CommonResponse<Long>> getTotalRevenue() {
        return new ResponseEntity<>(CommonResponse.success(revenueService.getTotalRevenue(), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }

    @GetMapping("/today")
    public ResponseEntity<CommonResponse<Long>> getTotalRevenueToday() {
        return new ResponseEntity<>(CommonResponse.success(revenueService.getTodayRevenue(), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }

    @GetMapping("/month")
    public ResponseEntity<CommonResponse<Long>> getTotalRevenueThisMonth() {
        return new ResponseEntity<>(CommonResponse.success(revenueService.getMonthRevenue(), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }

    @GetMapping("/year")
    public ResponseEntity<CommonResponse<Long>> getTotalRevenueThisYear() {
        return new ResponseEntity<>(CommonResponse.success(revenueService.getYearRevenue(), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }
}
