package com.joo.abysshop.service.admin;

import com.joo.abysshop.dto.admin.ChangeOrderStateRequest;
import com.joo.abysshop.dto.order.OrderListResponse;
import com.joo.abysshop.entity.order.OrderEntity;
import com.joo.abysshop.mapper.dto.ToOrderDTOMapper;
import com.joo.abysshop.mapper.mybatis.AdminMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminOrderManagementService {

    private final AdminMapper adminMapper;
    private final ToOrderDTOMapper toOrderDTOMapper;

    public List<OrderListResponse> getAllOrders() {
        List<OrderEntity> orderEntityList = adminMapper.findAllOrders();
        List<OrderListResponse> orderList = new ArrayList<>();

        for (OrderEntity orderEntity : orderEntityList) {
            orderList.add(toOrderDTOMapper.toOrderListResponse(orderEntity));
        }

        return orderList;
    }

    public void changeOrderState(ChangeOrderStateRequest changeOrderStateRequest) {
        Map<String, Object> changeStateMap = new HashMap<>();
        changeStateMap.put("orderId", changeOrderStateRequest.getOrderId());
        changeStateMap.put("newState", changeOrderStateRequest.getNewState());

        adminMapper.changeOrderState(changeStateMap);
    }
}