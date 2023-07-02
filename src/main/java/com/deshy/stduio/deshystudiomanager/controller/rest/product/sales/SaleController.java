package com.deshy.stduio.deshystudiomanager.controller.rest.product.sales;

import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.data.dto.PageDTO;
import com.deshy.stduio.deshystudiomanager.data.dto.product.ProductSaleDTO;
import com.deshy.stduio.deshystudiomanager.service.product.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products/sales")
public class SaleController {
    private final SaleService salesService;

    @GetMapping("{startPage}/to/{endPage}")
    public ResponseEntity<CommonResponse<PageDTO<ProductSaleDTO>>> getAllSaleByPaging(@PathVariable Long startPage,@PathVariable Long endPage) {
        return new ResponseEntity<>(CommonResponse.success(salesService.getAllSaleByPaging(startPage, endPage), CommonCode.FOUND_OK), HttpStatus.OK);
    }
}
