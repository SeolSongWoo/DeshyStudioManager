package com.deshy.stduio.deshystudiomanager.controller.rest.product.sales;

import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.data.dto.ProductSalesMetricsDTO;
import com.deshy.stduio.deshystudiomanager.service.product.metrics.ProfitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products/metrics/profit")
public class ProfitController {
    private final ProfitService profitService;

    @GetMapping
    public ResponseEntity<CommonResponse<Long>> getTotalProfit() {
        return new ResponseEntity<>(CommonResponse.success(profitService.getTotalProfit(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/today")
    public ResponseEntity<CommonResponse<Long>> getTodayTotalProfit() {
        return new ResponseEntity<>(CommonResponse.success(profitService.getTodayProfit(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/today/hour")
    public ResponseEntity<CommonResponse<List<ProductSalesMetricsDTO>>> getTodayTotalProfitByHour() {
        return new ResponseEntity<>(CommonResponse.success(profitService.getTodayProfitByHour(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/month")
    public ResponseEntity<CommonResponse<Long>> getThisMonthTotalProfit() {
        return new ResponseEntity<>(CommonResponse.success(profitService.getMonthProfit(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/month/day")
    public ResponseEntity<CommonResponse<List<ProductSalesMetricsDTO>>> getThisMonthTotalProfitByHour() {
        return new ResponseEntity<>(CommonResponse.success(profitService.getMonthProfitByDay(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/year")
    public ResponseEntity<CommonResponse<Long>> getThisYearTotalProfit() {
        return new ResponseEntity<>(CommonResponse.success(profitService.getYearProfit(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @GetMapping("/year/month")
    public ResponseEntity<CommonResponse<List<ProductSalesMetricsDTO>>> getThisYearTotalProfitByHour() {
        return new ResponseEntity<>(CommonResponse.success(profitService.getYearProfitByMonth(), CommonCode.FOUND_OK), HttpStatus.OK);
    }

}