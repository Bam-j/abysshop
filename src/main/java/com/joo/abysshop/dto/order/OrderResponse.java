package com.joo.abysshop.dto.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@Deprecated
public class OrderResponse {

    protected Long userId;
    private Long productId;
    private Long orderId;
}
