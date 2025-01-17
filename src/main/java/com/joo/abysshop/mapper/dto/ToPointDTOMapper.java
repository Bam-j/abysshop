package com.joo.abysshop.mapper.dto;

import com.joo.abysshop.dto.point.PointRechargeDetailResponse;
import com.joo.abysshop.dto.point.PointRechargeListResponse;
import com.joo.abysshop.entity.point.PointRechargeDetailEntity;
import com.joo.abysshop.entity.point.PointRechargeEntity;

public interface ToPointDTOMapper {

    PointRechargeListResponse toPointRechargeListResponse(PointRechargeEntity pointRechargeEntity);

    PointRechargeDetailResponse toPointRechargeDetailResponse(PointRechargeDetailEntity pointRechargeDetailEntity);
}
