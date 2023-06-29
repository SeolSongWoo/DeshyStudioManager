package com.deshy.stduio.deshystudiomanager.controller.rest.product;

import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.data.dto.ProductRegDTO;
import com.deshy.stduio.deshystudiomanager.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequestMapping("/api/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<CommonResponse<?>> registration(@RequestBody ProductRegDTO productRegDTO, Principal principal) {
        productService.registration(productRegDTO,principal.getName());
        return new ResponseEntity<>(CommonResponse.success(null, CommonCode.CREATE_OK), HttpStatus.OK);
    }
}
