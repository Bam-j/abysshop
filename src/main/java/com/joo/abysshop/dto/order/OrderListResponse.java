package com.joo.abysshop.dto.order;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OrderListResponse {

    private Long orderId;
    private Long userId;
    private Date orderDate;
    private Long totalPrice; //TODO: 구조상 totalPoints로 변경하는게 좋아보임
    private String orderState;
}
