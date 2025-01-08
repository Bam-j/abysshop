package com.joo.abysshop.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductEntity {

    private Long productId;
    private String productName;
    private Long price;
    private String description;
    private String productType;
}
