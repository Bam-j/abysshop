package com.joo.abysshop.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInOrderEntity {

    private Long userId;
    private Long productId;
    private Long cartId;
    private Long orderId;
    private String productName;
    private Long price;
    private String description;
    private String productType;
}
