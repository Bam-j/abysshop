package com.joo.abysshop.entity;

import com.joo.abysshop.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductEntity {

    private Long productId;
    private String productName;
    private Long price;
    private String description;
    private ProductType productType;
}
