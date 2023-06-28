package com.deshy.stduio.deshystudiomanager.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRegDTO {
    private String prpProductName;
    private String prpProductVendor;
    private String prpProductStyle;
    private String prpProductSize;
    private Long prpProductQuantity;
    private Long prpProductOriginPrice;
}
