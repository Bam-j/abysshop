package com.joo.abysshop.service.point;

import com.joo.abysshop.dto.point.PointRechargeDetailResponse;
import com.joo.abysshop.dto.point.SavePointRechargeDetailRequest;
import com.joo.abysshop.entity.point.PointRechargeDetailEntity;
import com.joo.abysshop.entity.point.SavePointRechargeDetailEntity;
import com.joo.abysshop.mapper.dto.ToPointDTOMapper;
import com.joo.abysshop.mapper.entity.ToPointEntityMapper;
import com.joo.abysshop.mapper.mybatis.PointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointRechargeManagementService {

    private final PointMapper pointMapper;
    private final ToPointDTOMapper toPointDTOMapper;
    private final ToPointEntityMapper ToPointEntityMapper;

    public PointRechargeDetailResponse getDetail(Long rechargeId) {
        //하나의 주문 당(rechargeId) 하나의 detail이 생기므로 rechargeId로 탐색 수행
        PointRechargeDetailEntity pointRechargeDetailEntity = pointMapper.findPointRechargeDetail(
            rechargeId);
        return toPointDTOMapper.toPointRechargeDetailResponse(pointRechargeDetailEntity);
    }

    public void saveDetail(SavePointRechargeDetailRequest savePointRechargeDetailRequest) {
        SavePointRechargeDetailEntity savePointRechargeDetailEntity = ToPointEntityMapper.toSavePointRechargeDetailEntity(
            savePointRechargeDetailRequest);
        pointMapper.insertPointRechargeDetail(savePointRechargeDetailEntity);
    }
}
