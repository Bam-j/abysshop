package com.joo.abysshop.dto.admin;

import com.joo.abysshop.enums.OrderState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ChangeOrderStateRequest {

    private Long orderId;
    private String newState;
}
