package com.joo.abysshop.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductImageEntity {

    private Long imageId;
    private Long productId;
    private byte[] image;
    private String originalFileName;
}
