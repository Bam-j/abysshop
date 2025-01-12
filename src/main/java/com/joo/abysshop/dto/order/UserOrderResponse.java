package com.joo.abysshop.dto.order;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserOrderResponse {

    private Long orderId;
    private Date orderDate;
    private Long totalPrice;
    private String orderState;
}
