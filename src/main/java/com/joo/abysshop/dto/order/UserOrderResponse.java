package com.joo.abysshop.dto.order;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@Deprecated //OrderListResponse로 통합
public class UserOrderResponse {

    private Long orderId;
    private Date orderDate;
    private Long totalPoints;
    private String orderState;
}
