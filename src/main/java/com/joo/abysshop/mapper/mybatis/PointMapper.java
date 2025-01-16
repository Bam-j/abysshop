package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.entity.point.PointRechargeEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper {

    List<PointRechargeEntity> findAllPointRecharge();
}
