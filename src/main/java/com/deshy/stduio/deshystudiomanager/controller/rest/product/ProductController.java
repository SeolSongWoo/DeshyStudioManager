package com.deshy.stduio.deshystudiomanager.controller.rest.product;

import com.deshy.stduio.deshystudiomanager.aop.UserCheck;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.data.dto.ProductRegDTO;
import com.deshy.stduio.deshystudiomanager.data.entity.Member;
import com.deshy.stduio.deshystudiomanager.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/api/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<CommonResponse<?>> createProduct(@UserCheck Member member) {
        ProductRegDTO productRegDTO1 = new ProductRegDTO();
        productService.createProduct(productRegDTO1,member);
        return new ResponseEntity<>(CommonResponse.success(null, CommonCode.CREATE_OK), HttpStatus.OK);
    }

    @PostMapping("/size")
    public ResponseEntity<CommonResponse<?>> createSize(@RequestParam String size,@UserCheck Member member) {
        productService.createSize(size,member);
        return new ResponseEntity<>(CommonResponse.success(null, CommonCode.CREATE_OK), HttpStatus.OK);
    }
}
