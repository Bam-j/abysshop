package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.entity.point.CreatePointRechargeEntity;
import com.joo.abysshop.entity.point.PointRechargeDetailEntity;
import com.joo.abysshop.entity.point.PointRechargeEntity;
import com.joo.abysshop.entity.point.UpdatePointRechargeDetailEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper {

    List<PointRechargeEntity> findAllPointRecharge();

    void insertPointRecharge(CreatePointRechargeEntity createPointRechargeEntity);

    void changePointRechargeState(Map<String, Object> changeStateMap);

    List<PointRechargeEntity> getUserPointRecharges(Long userId);

    List<PointRechargeDetailEntity> findAllPointRechargeDetail();

    void updatePointRechargeDetail(UpdatePointRechargeDetailEntity updatePointRechargeDetailEntity);
}
