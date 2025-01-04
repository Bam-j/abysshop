package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.entity.ProductInOrderEntity;
import com.joo.abysshop.enums.ProductType;
import com.joo.abysshop.enums.UserType;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    UserType getUserType(Long id);

    List<ProductInOrderEntity> findAllProductInOrder(ProductType productType);

    void changeOrderState(Map changeStateMap);
}
