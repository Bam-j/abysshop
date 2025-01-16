package com.joo.abysshop.mapper.dto;

import com.joo.abysshop.dto.point.PointRechargeListResponse;
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
}
