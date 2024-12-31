package com.joo.abysshop.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductEntity {

    private Long userId;
    private Long productId;
    private Long cartId;
    private Long orderId;
}
