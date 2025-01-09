package com.joo.abysshop.entity.order;

import com.joo.abysshop.enums.OrderState;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderEntity {

    private Long orderId;
    private Long userId;
    private Date orderDate;
    private Long totalPrice;
    private OrderState orderState;
}
