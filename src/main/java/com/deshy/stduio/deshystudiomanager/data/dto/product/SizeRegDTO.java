package com.deshy.stduio.deshystudiomanager.data.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SizeRegDTO {
    private UUID categoryUid;
    private String sizeName;
}
