package com.joo.abysshop.dto.order;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddCartRequest {

    private Integer userId;
    private Integer productId;
    private Integer cartId;
}
