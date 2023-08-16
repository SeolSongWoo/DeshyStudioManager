package com.deshy.stduio.deshystudiomanager.service.product;

import com.deshy.stduio.deshystudiomanager.data.dto.PageDTO;
import com.deshy.stduio.deshystudiomanager.data.dto.product.ProductSaleDTO;
import com.deshy.stduio.deshystudiomanager.data.entity.Member;
import com.deshy.stduio.deshystudiomanager.data.entity.Product;
import com.deshy.stduio.deshystudiomanager.data.entity.ProductSale;
import com.deshy.stduio.deshystudiomanager.exception.OutOfStockException;
import com.deshy.stduio.deshystudiomanager.repository.ProductRepository;
import com.deshy.stduio.deshystudiomanager.repository.ProductSaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final ProductSaleRepository productSaleRepository;
    private final ProductRepository productRepository;

    public PageDTO<ProductSaleDTO> getAllSaleByPaging(Long StartPage, Long EndPage) {
        Page<ProductSale> productSales = productSaleRepository.findAll(PageRequest.of(StartPage.intValue(), EndPage.intValue(), Sort.by("saleDate")));
        return PageDTO.of(productSales, ProductSaleDTO::of);
    }

    @Transactional
    public void saleProduct(ProductSaleDTO productSaleDTO, Member member) {
        Product product = productRepository.findByUid(productSaleDTO.getProduct())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Product:" + productSaleDTO.getProduct()));
        ProductSale productSale = ProductSale.createProductSale(member,product, productSaleDTO.getSaleQuantity(), productSaleDTO.getSalePrice(), productSaleDTO.getSaleDate());
        productSaleRepository.save(productSale);
        if(product.getStockQuantity() > productSale.getSaleQuantity()) {
            product.saleProduct(productSale.getSaleQuantity());
        }else {
            throw new OutOfStockException("재고 수량 초과");
        }
    }
}
