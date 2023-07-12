package com.deshy.stduio.deshystudiomanager.service.product;

import com.deshy.stduio.deshystudiomanager.data.dto.product.*;
import com.deshy.stduio.deshystudiomanager.data.entity.*;
import com.deshy.stduio.deshystudiomanager.exception.DuplicateException;
import com.deshy.stduio.deshystudiomanager.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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
            throw new DuplicateException("중복 상품 존재: "+ productRegDTO.getName());
        }
    }

    public List<ProductDTO> getProducts(Member member) {
        return ProductDTO.ofList(productRepository.findAllByMember(member));
    }

    public void createCategory(CategoryRegDTO categoryRegDTO, Member member) {
        ProductCategory category = ProductCategory.create(categoryRegDTO.getCategory(), member);
        try {
            productCategoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateException("중복 카테고리명 존재:"+ categoryRegDTO.getCategory());
        }
    }

    public List<CategoryDTO> getCategory() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();

        return CategoryDTO.ofList(productCategories);
    }

    public void deleteCategory(UUID uid) {
        ProductCategory category = productCategoryRepository.findByUid(uid).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 카테고리: "+uid));
        productCategoryRepository.delete(category);
    }

    public void createSize(SizeRegDTO sizeRegDTO) {
        ProductCategory category = productCategoryRepository.findByUid(sizeRegDTO.getCategoryUid())
                .orElseThrow(() -> new IllegalArgumentException("Invalid vendor Name:" + sizeRegDTO.getCategoryUid()));
        ProductSize size = ProductSize.create(category,sizeRegDTO.getSizeName());

        try {
            productSizeRepository.save(size);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateException("중복 사이즈명 존재:"+ sizeRegDTO.getSizeName());
        }
    }

    public List<SizeDTO> getSizeByCategoryUid(UUID categoryUid) {
        List<ProductSize> productSizes = productSizeRepository.findByCategoryUid(categoryUid);
        return SizeDTO.ofList(productSizes);
    }

    public void deleteSize(UUID uid) {
        ProductSize size = productSizeRepository.findByUid(uid).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 사이즈: "+uid));
        productSizeRepository.delete(size);
    }
}
