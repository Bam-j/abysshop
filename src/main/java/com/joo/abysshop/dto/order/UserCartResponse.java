package com.joo.abysshop.dto.order;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserCartResponse {

    private Integer cartId;
    private Integer userId;
    private Integer quantity;
    private Integer totalPrice;
}
