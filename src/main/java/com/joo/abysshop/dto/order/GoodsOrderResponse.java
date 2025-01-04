package com.joo.abysshop.dto.order;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GoodsOrderResponse {

    private Long userId;
    private Long productId;
    private Long orderId;
    private String productName;
    private Long price;
}
