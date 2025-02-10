package com.joo.abysshop.dto.point;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PointRechargeDetailResponse {

    private Long rechargeDetailId;
    private Long rechargeId;
    private Long userId;
    //private Long nickname; userId 받아올때 getNickname으로 닉네임 가져오기
    private String bank;
    private String accountNumber;
    private Date depositConfirmedTime;
}
