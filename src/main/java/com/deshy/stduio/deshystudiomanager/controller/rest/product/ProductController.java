package com.deshy.stduio.deshystudiomanager.controller.rest.product;

import com.deshy.stduio.deshystudiomanager.authentication.AuthUser;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.data.dto.product.CategoryDTO;
import com.deshy.stduio.deshystudiomanager.data.dto.product.CategoryRegDTO;
import com.deshy.stduio.deshystudiomanager.data.dto.product.ProductRegDTO;
import com.deshy.stduio.deshystudiomanager.data.entity.Member;
import com.deshy.stduio.deshystudiomanager.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<CommonResponse<?>> createProduct(@RequestBody ProductRegDTO productRegDTO, @AuthUser Member member) {
        productService.createProduct(productRegDTO,member);
        return new ResponseEntity<>(CommonResponse.success(null, CommonCode.CREATE_OK), HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<CommonResponse<?>> createCategory(@RequestBody CategoryRegDTO category, @AuthUser Member member) {
        productService.createCategory(category,member);
        return new ResponseEntity<>(CommonResponse.success(null, CommonCode.CREATE_OK), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<CommonResponse<List<CategoryDTO>>> getCategory() {
        return new ResponseEntity<>(CommonResponse.success(productService.getCategory(),CommonCode.FOUND_OK), HttpStatus.OK);
    }

    @DeleteMapping("/category/{uid}")
    public ResponseEntity<CommonResponse<?>> deleteCategory(@PathVariable UUID uid) {
        productService.deleteCategory(uid);
        return new ResponseEntity<>(CommonResponse.success(null,CommonCode.DELETE_OK), HttpStatus.OK);
    }
}
