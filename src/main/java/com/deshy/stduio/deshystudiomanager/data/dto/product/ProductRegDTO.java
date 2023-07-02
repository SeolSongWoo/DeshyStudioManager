package com.deshy.stduio.deshystudiomanager.data.dto.product;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private UUID vendor;
    @NotEmpty
    private UUID category;
    @NotEmpty
    private UUID size;
    @NotEmpty
    private Long quantity;
    @NotEmpty
    private Long originPrice;

    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate regDate;
}
