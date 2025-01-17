package com.joo.abysshop.mapper.dto;

import com.joo.abysshop.dto.point.PointRechargeDetailResponse;
import com.joo.abysshop.dto.point.PointRechargeListResponse;
import com.joo.abysshop.entity.point.PointRechargeDetailEntity;
import com.joo.abysshop.entity.point.PointRechargeEntity;
import org.springframework.stereotype.Component;

@Component
public class ToPointDTOMapperImpl implements ToPointDTOMapper {

    @Override
    public PointRechargeListResponse toPointRechargeListResponse(
        PointRechargeEntity pointRechargeEntity) {
        return PointRechargeListResponse.builder()
            .rechargeId(pointRechargeEntity.getRechargeId())
            .userId(pointRechargeEntity.getUserId())
            .nickname(pointRechargeEntity.getNickname())
            .points(pointRechargeEntity.getPoints())
            .requestTime(pointRechargeEntity.getRequestTime())
            .rechargeRequestState(pointRechargeEntity.getRechargeRequestState())
            .build();
    }

    @Override
    public PointRechargeDetailResponse toPointRechargeDetailResponse(
        PointRechargeDetailEntity pointRechargeDetailEntity) {
        return PointRechargeDetailResponse.builder()
            .rechargeId(pointRechargeDetailEntity.getRechargeId())
            .userId(pointRechargeDetailEntity.getUserId())
            .bank(pointRechargeDetailEntity.getBank())
            .accountNumber(pointRechargeDetailEntity.getAccountNumber())
            .depositConfirmedTime(pointRechargeDetailEntity.getDepositConfirmedTime())
            .build();
    }
}
