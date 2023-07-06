package com.deshy.stduio.deshystudiomanager.service.product;

import com.deshy.stduio.deshystudiomanager.data.dto.PageDTO;
import com.deshy.stduio.deshystudiomanager.data.dto.product.ProductSaleDTO;
import com.deshy.stduio.deshystudiomanager.data.entity.ProductSale;
import com.deshy.stduio.deshystudiomanager.repository.ProductSaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final ProductSaleRepository productSaleRepository;

    public PageDTO<ProductSaleDTO> getAllSaleByPaging(Long StartPage, Long EndPage) {
        Page<ProductSale> productSales = productSaleRepository.findAll(PageRequest.of(StartPage.intValue(), EndPage.intValue(), Sort.by("saleDate")));
        return PageDTO.of(productSales, ProductSaleDTO::of);
    }
}
