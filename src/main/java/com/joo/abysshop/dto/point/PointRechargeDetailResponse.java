package com.joo.abysshop.dto.point;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PointRechargeDetailResponse {

    private Long rechargeId;
    private Long userId;
    private String bank;
    private String accountNumber;
    private Date depositConfirmedTime;
}
