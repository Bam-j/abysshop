package com.joo.abysshop.mapper.entity;

import com.joo.abysshop.dto.point.CreatePointRechargeRequest;
import com.joo.abysshop.dto.point.SavePointRechargeDetailRequest;
import com.joo.abysshop.entity.point.CreatePointRechargeEntity;
import com.joo.abysshop.entity.point.SavePointRechargeDetailEntity;

public interface ToPointEntityMapper {

    CreatePointRechargeEntity toPointRechargeEntity(
        CreatePointRechargeRequest createPointRechargeRequest);

    SavePointRechargeDetailEntity toSavePointRechargeDetailEntity(
        SavePointRechargeDetailRequest savePointRechargeDetailRequest);
}
