package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.entity.point.CreatePointRechargeEntity;
import com.joo.abysshop.entity.point.PointRechargeDetailEntity;
import com.joo.abysshop.entity.point.PointRechargeEntity;
import com.joo.abysshop.entity.point.SavePointRechargeDetailEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper {

    List<PointRechargeEntity> findAllPointRecharge();

    void insertPointRecharge(CreatePointRechargeEntity createPointRechargeEntity);

    void changePointRechargeState(Map<String, Object> changeStateMap);

    PointRechargeDetailEntity findPointRechargeDetail(Long rechargeId);

    void insertPointRechargeDetail(SavePointRechargeDetailEntity savePointRechargeDetailEntity);

    List<PointRechargeEntity> getUserPointRecharges(Long userId);
}
