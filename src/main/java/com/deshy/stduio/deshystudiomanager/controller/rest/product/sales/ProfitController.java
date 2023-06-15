package com.deshy.stduio.deshystudiomanager.controller.rest.product.sales;

import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.service.product.sales.ProfitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products/sales/profit")
public class ProfitController {
    private final ProfitService profitService;

    @GetMapping
    public ResponseEntity<CommonResponse<Long>> getTotalProfit() {
        return new ResponseEntity<>(CommonResponse.success(profitService.getTotalProfit(), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }

    @GetMapping("/today")
    public ResponseEntity<CommonResponse<Long>> getTotalProfitToday() {
        return new ResponseEntity<>(CommonResponse.success(profitService.getTodayProfit(), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }

    @GetMapping("/month")
    public ResponseEntity<CommonResponse<Long>> getTotalProfitThisMonth() {
        return new ResponseEntity<>(CommonResponse.success(profitService.getMonthProfit(), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }

    @GetMapping("/year")
    public ResponseEntity<CommonResponse<Long>> getTotalProfitThisYear() {
        return new ResponseEntity<>(CommonResponse.success(profitService.getYearProfit(), CommonCode.FOUND_OK), HttpStatus.FOUND);
    }
}
