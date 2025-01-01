package com.joo.abysshop.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImageEntity {

    private Long imageId;
    private Long productId;
    private byte[] image;
    private String originalFileName;
}
