package com.deshy.stduio.deshystudiomanager.service.product;

import com.deshy.stduio.deshystudiomanager.data.dto.ProductRegDTO;
import com.deshy.stduio.deshystudiomanager.data.entity.*;
import com.deshy.stduio.deshystudiomanager.exception.ProductDuplicateException;
import com.deshy.stduio.deshystudiomanager.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;
    private final VendorRepository vendorRepository;
    private final ProductSizeRepository productSizeRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Transactional
    public void createProduct(ProductRegDTO productRegDTO,Member member) {
        Vendor vendor = vendorRepository.findByUid(productRegDTO.getVendor())
                .orElseThrow(() -> new IllegalArgumentException("Invalid vendor Name:" + productRegDTO.getVendor()));

        ProductSize size = productSizeRepository.findByUid(productRegDTO.getSize())
                .orElseThrow(() -> new IllegalArgumentException("Invalid size Name:" + productRegDTO.getSize()));

        ProductCategory category = productCategoryRepository.findByUid(productRegDTO.getCategory())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category Name:" + productRegDTO.getCategory()));

        Product product = Product.createProduct(productRegDTO.getName(),size,category,productRegDTO.getOriginPrice()
        ,productRegDTO.getQuantity(),productRegDTO.getRegDate(),member,vendor);
        try {
            productRepository.save(product);
        } catch (DataIntegrityViolationException e) {
            throw new ProductDuplicateException("중복 상품 존재: "+ productRegDTO.getName());
        }
    }

    public void createSize(String size, Member member) {

    }

    private Member memberCheck(String userId) {
        return memberRepository.findMemberById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member Name:" + userId));
    }
}
