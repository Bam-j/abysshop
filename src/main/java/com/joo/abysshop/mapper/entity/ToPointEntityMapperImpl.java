package com.joo.abysshop.mapper.entity;

import com.joo.abysshop.dto.point.CreatePointRechargeRequest;
import com.joo.abysshop.dto.point.SavePointRechargeDetailRequest;
import com.joo.abysshop.entity.point.CreatePointRechargeEntity;
import com.joo.abysshop.entity.point.SavePointRechargeDetailEntity;
import org.springframework.stereotype.Component;

@Component
public class ToPointEntityMapperImpl implements ToPointEntityMapper {

    @Override
    public CreatePointRechargeEntity toPointRechargeEntity(
        CreatePointRechargeRequest createPointRechargeRequest) {
        return CreatePointRechargeEntity.builder()
            .userId(createPointRechargeRequest.getUserId())
            .nickname(createPointRechargeRequest.getNickname())
            .points(createPointRechargeRequest.getPoints())
            .build();
    }

    @Override
    public SavePointRechargeDetailEntity toSavePointRechargeDetailEntity(
        SavePointRechargeDetailRequest savePointRechargeDetailRequest) {
        return SavePointRechargeDetailEntity.builder()
            .rechargeId(savePointRechargeDetailRequest.getRechargeId())
            .userId(savePointRechargeDetailRequest.getUserId())
            .bank(savePointRechargeDetailRequest.getBank())
            .accountNumber(savePointRechargeDetailRequest.getAccountNumber())
            .build();
    }
}
