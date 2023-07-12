package com.deshy.stduio.deshystudiomanager.data.dto.vendor;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VendorSalesDTO {
    private String vendorName;
    private Long totalVolume;
    private Long totalProfit;
    private Long totalRevenue;
}
