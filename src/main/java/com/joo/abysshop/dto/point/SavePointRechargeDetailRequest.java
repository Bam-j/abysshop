package com.joo.abysshop.dto.point;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SavePointRechargeDetailRequest {

    private Long rechargeId;
    private Long userId;
    private String bank;
    private String accountNumber;
}
