package com.joo.abysshop.entity.order;

import com.joo.abysshop.enums.OrderState;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderEntity {

    private Long orderId;
    private Long userId;
    private Date orderDate;
    private Long totalPrice;
    private OrderState orderState;
}
