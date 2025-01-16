package com.joo.abysshop.dto.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@Deprecated
public class GoodsOrderResponse extends OrderResponse {

    private String productName;
    private Long price;
}
