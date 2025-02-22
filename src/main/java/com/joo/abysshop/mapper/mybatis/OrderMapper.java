package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.entity.order.CreateOrderEntity;
import com.joo.abysshop.entity.order.OrderEntity;
import java.util.List;

public interface OrderMapper {

    void insertOrder(CreateOrderEntity createOrderEntity);

    List<OrderEntity> getUserOrders(Long userId);

    int countAllOrders();
}
