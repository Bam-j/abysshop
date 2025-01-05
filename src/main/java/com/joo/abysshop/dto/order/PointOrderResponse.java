package com.joo.abysshop.dto.order;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PointOrderResponse implements OrderResponse {

    private Long userId;
    private Long productId;
    private Long orderId;
    private Long price;
}
