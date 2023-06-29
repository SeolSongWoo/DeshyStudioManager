package com.deshy.stduio.deshystudiomanager.data.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class ProductRegDTO {
    @NotEmpty
    private String prpProductName;
    @NotEmpty
    private String prpProductVendor;
    @NotEmpty
    private String prpProductCategory;
    @NotEmpty
    private String prpProductSize;
    @NotEmpty
    private Long prpProductQuantity;
    @NotEmpty
    private Long prpProductOriginPrice;

    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate prpRegDate;
}
