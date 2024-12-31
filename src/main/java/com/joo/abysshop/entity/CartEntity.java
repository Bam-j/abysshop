package com.joo.abysshop.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartEntity {

    private Long cartId;
    private Long userId;
    private Long quantity;
    private Long totalPrice;
}
