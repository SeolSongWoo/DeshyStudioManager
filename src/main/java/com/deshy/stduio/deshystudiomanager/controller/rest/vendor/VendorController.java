package com.deshy.stduio.deshystudiomanager.controller.rest.vendor;


import com.deshy.stduio.deshystudiomanager.authentication.AuthUser;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonCode;
import com.deshy.stduio.deshystudiomanager.controller.rest.response.CommonResponse;
import com.deshy.stduio.deshystudiomanager.data.dto.vendor.VendorDTO;
import com.deshy.stduio.deshystudiomanager.data.dto.vendor.VendorStoreDTO;
import com.deshy.stduio.deshystudiomanager.data.entity.Member;
import com.deshy.stduio.deshystudiomanager.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vendor")
@RequiredArgsConstructor
public class VendorController {
    private final VendorService vendorService;

    @PostMapping
    public ResponseEntity<CommonResponse<?>> createVendor(@RequestBody VendorDTO vendorDTO, @AuthUser Member member) {
        vendorService.createVendor(vendorDTO,member);
        return new ResponseEntity<>(CommonResponse.success(null,CommonCode.CREATE_OK),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<VendorDTO>>> getVendors() {
        return new ResponseEntity<>(CommonResponse.success(vendorService.getVendors(),CommonCode.FOUND_OK),HttpStatus.OK);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<CommonResponse<?>> deleteVendor(@PathVariable UUID uid) {
        vendorService.deleteVendor(uid);
        return new ResponseEntity<>(CommonResponse.success(null,CommonCode.DELETE_OK),HttpStatus.OK);
    }


    @PostMapping("/store")
    public ResponseEntity<CommonResponse<?>> createVendorStore(@RequestBody VendorStoreDTO vendorStoreDTO, @AuthUser Member member) {
        vendorService.createStore(vendorStoreDTO,member);
        return new ResponseEntity<>(CommonResponse.success(null, CommonCode.CREATE_OK), HttpStatus.OK);
    }

    @GetMapping("/store")
    public ResponseEntity<CommonResponse<List<VendorStoreDTO>>> getVendorStore() {
        return new ResponseEntity<>(CommonResponse.success(vendorService.getStore(),CommonCode.FOUND_OK),HttpStatus.OK);
    }

    @DeleteMapping("/store/{uid}")
    public ResponseEntity<CommonResponse<?>> deleteVendorStore(@PathVariable UUID uid) {
        vendorService.deleteStore(uid);
        return new ResponseEntity<>(CommonResponse.success(null, CommonCode.DELETE_OK), HttpStatus.OK);
    }
}
