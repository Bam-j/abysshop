package com.joo.abysshop.entity.point;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SavePointRechargeDetailEntity {

    private Long rechargeId;
    private Long userId;
    private String bank;
    private String accountNumber;
}
