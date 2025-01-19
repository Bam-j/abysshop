package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.entity.order.CreateOrderEntity;

public interface OrderMapper {

    void insertOrder(CreateOrderEntity createOrderEntity);
}
