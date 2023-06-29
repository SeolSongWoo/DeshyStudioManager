package com.deshy.stduio.deshystudiomanager.data.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ProductRegDTO {
    private String prpProductName;
    private String prpProductVendor;
    private String prpProductCategory;
    private String prpProductSize;
    private Long prpProductQuantity;
    private Long prpProductOriginPrice;
    private LocalDate prpRegDate;
}
