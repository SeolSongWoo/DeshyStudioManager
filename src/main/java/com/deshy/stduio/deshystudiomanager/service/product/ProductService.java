package com.deshy.stduio.deshystudiomanager.service.product;

import com.deshy.stduio.deshystudiomanager.data.dto.ProductRegDTO;
import com.deshy.stduio.deshystudiomanager.data.entity.*;
import com.deshy.stduio.deshystudiomanager.exception.ProductDuplicateException;
import com.deshy.stduio.deshystudiomanager.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;
    private final VendorRepository vendorRepository;
    private final ProductSizeRepository productSizeRepository;
    private final ProductCategoryRepository productCategoryRepository;


    @Transactional
    public void registration(ProductRegDTO productRegDTO,String userId) {
        Member member = memberRepository.findMemberById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid member Name:" + userId));

        Vendor vendor = vendorRepository.findByName(productRegDTO.getPrpProductVendor())
                .orElseThrow(() -> new IllegalArgumentException("Invalid vendor Name:" + productRegDTO.getPrpProductVendor()));

        ProductSize size = productSizeRepository.findBySize(productRegDTO.getPrpProductSize())
                .orElseThrow(() -> new IllegalArgumentException("Invalid size Name:" + productRegDTO.getPrpProductSize()));

        ProductCategory category = productCategoryRepository.findByCategory(productRegDTO.getPrpProductCategory())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category Name:" + productRegDTO.getPrpProductCategory()));

        Product product = Product.createProduct(productRegDTO.getPrpProductName(),size,category,productRegDTO.getPrpProductOriginPrice()
        ,productRegDTO.getPrpProductQuantity(),productRegDTO.getPrpRegDate(),member,vendor);
        try {
            productRepository.save(product);
        } catch (DataIntegrityViolationException e) {
            throw new ProductDuplicateException("중복 상품 존재: "+ productRegDTO.getPrpProductName());
        }
    }
}
