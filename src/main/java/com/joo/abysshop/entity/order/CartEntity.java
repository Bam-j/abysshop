package com.joo.abysshop.entity.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartEntity {

    private Long cartId;
    private Long userId;
    private Long quantity;
    private Long totalPrice;
}
