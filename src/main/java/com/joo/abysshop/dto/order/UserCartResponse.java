package com.joo.abysshop.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserCartResponse {

    private Integer cartId;
    private Integer userId;
    private Integer quantity;
    private Integer totalPrice;
}
