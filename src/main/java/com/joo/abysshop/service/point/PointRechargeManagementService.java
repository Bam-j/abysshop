package com.joo.abysshop.service.point;

import com.joo.abysshop.dto.point.PointRechargeDetailListResponse;
import com.joo.abysshop.dto.point.SavePointRechargeDetailRequest;
import com.joo.abysshop.entity.point.PointRechargeDetailEntity;
import com.joo.abysshop.entity.point.SavePointRechargeDetailEntity;
import com.joo.abysshop.mapper.dto.ToPointDTOMapper;
import com.joo.abysshop.mapper.entity.ToPointEntityMapper;
import com.joo.abysshop.mapper.mybatis.PointMapper;
import com.joo.abysshop.mapper.mybatis.UserMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointRechargeManagementService {

    private final PointMapper pointMapper;
    private final UserMapper userMapper;
    private final ToPointDTOMapper toPointDTOMapper;
    private final ToPointEntityMapper toPointEntityMapper;

    public List<PointRechargeDetailListResponse> getAllPointRechargeDetail() {
        List<PointRechargeDetailEntity> pointRechargeDetailEntityList = pointMapper.findAllPointRechargeDetail();
        List<PointRechargeDetailListResponse> pointRechargeDetailList = new ArrayList<>();

        for (PointRechargeDetailEntity pointRechargeDetailEntity : pointRechargeDetailEntityList) {
            String nickname = userMapper.getNickname(pointRechargeDetailEntity.getUserId());
            pointRechargeDetailList.add(
                toPointDTOMapper.toPointRechargeDetailResponse(pointRechargeDetailEntity,
                    nickname));
        }

        return pointRechargeDetailList;
    }

    public void saveDetail(SavePointRechargeDetailRequest savePointRechargeDetailRequest) {
        SavePointRechargeDetailEntity savePointRechargeDetailEntity = toPointEntityMapper.toSavePointRechargeDetailEntity(
            savePointRechargeDetailRequest);
        pointMapper.insertPointRechargeDetail(savePointRechargeDetailEntity);
    }
}
