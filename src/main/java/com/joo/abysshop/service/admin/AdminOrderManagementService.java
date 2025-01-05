package com.joo.abysshop.service.admin;

import com.joo.abysshop.dto.order.GoodsOrderResponse;
import com.joo.abysshop.dto.order.OrderResponse;
import com.joo.abysshop.dto.order.PointOrderResponse;
import com.joo.abysshop.entity.ProductInOrderEntity;
import com.joo.abysshop.enums.ProductType;
import com.joo.abysshop.mapper.dto.ToOrderDTOMapper;
import com.joo.abysshop.mapper.dto.ToOrderDTOMapperImpl;
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

    public List<OrderResponse> filterOrders(ProductType productType) {
        List<ProductInOrderEntity> productInOrderList =
            adminMapper.findAllProductInOrder(productType);
        List<OrderResponse> orderResponseList = new ArrayList<>();

        for (ProductInOrderEntity productInOrderEntity : productInOrderList) {
            orderResponseList.add(
                toOrderDTOMapper.mapToOrderResponse(productInOrderEntity, productType));
        }

        return orderResponseList;
    }

    public void changeOrderState(Long orderId, String newState) {
        Map<String, Object> changeStateMap = new HashMap<>();
        changeStateMap.put("orderId", orderId);
        changeStateMap.put("newState", newState);

        adminMapper.changeOrderState(changeStateMap);
    }
}