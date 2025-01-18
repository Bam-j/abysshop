package com.joo.abysshop.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserCartItemResponse {

    private Integer cartId;
    private Integer userId;
    private Integer quantity;
    private Integer totalPoints;
}
