package com.joo.abysshop.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductImageEntity {

    private Long imageId;
    private Long productId;
    private byte[] image;
    private String originalFileName;
}
