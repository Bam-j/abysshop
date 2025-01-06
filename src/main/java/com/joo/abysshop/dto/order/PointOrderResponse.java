package com.joo.abysshop.dto.order;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class PointOrderResponse extends OrderResponse {

    private Long price;
}
