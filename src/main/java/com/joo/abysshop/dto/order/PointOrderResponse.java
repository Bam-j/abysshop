package com.joo.abysshop.dto.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@Deprecated
public class PointOrderResponse extends OrderResponse {

    private Long price;
}
