package com.deshy.stduio.deshystudiomanager.data.dto.product;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SizeRegDTO {
    private UUID categoryUid;
    private String sizeName;
}
