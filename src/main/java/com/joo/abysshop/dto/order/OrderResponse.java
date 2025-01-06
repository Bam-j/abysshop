package com.joo.abysshop.dto.order;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class OrderResponse {

    protected Long userId;
    private Long productId;
    private Long orderId;
}
