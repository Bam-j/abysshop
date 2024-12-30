package com.joo.abysshop.dto.admin;

import com.joo.abysshop.enums.OrderState;

public class ChangeOrderStateRequestDTO {

    private Integer orderId;
    private OrderState orderState;
}
