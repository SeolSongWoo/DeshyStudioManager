package com.deshy.stduio.deshystudiomanager.data.dto;

import com.deshy.stduio.deshystudiomanager.data.entity.ProductSale;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PageDTO<DTO> {
    private int pageNumber;
    private int totalPages;
    private long totalElements;
    private List<DTO> dtoData;

    public static <T, D> PageDTO<D> of(Page<T> entityPage, Function<T, D> converterFunction) {
        return PageDTO.<D>builder()
                .pageNumber(entityPage.getNumber())
                .totalPages(entityPage.getTotalPages())
                .totalElements(entityPage.getTotalElements())
                .dtoData(entityPage.getContent().stream().map(converterFunction).collect(Collectors.toList()))
                .build();
    }

}