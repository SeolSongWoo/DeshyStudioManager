package com.deshy.stduio.deshystudiomanager.service.product;

import com.deshy.stduio.deshystudiomanager.data.dto.ProductRegDTO;
import com.deshy.stduio.deshystudiomanager.data.entity.Product;
import com.deshy.stduio.deshystudiomanager.data.entity.ProductSale;
import com.deshy.stduio.deshystudiomanager.repository.ProductRepository;
import com.deshy.stduio.deshystudiomanager.repository.ProductSaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void registration(ProductRegDTO productRegDTO) {
        Optional<Product> product = productRepository.findByName(productRegDTO.getPrpProductName());
        product.orElseThrow(RuntimeException::new);

    }
}
