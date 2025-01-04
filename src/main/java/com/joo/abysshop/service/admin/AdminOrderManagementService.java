package com.joo.abysshop.service.admin;

import com.joo.abysshop.dto.order.GoodsOrderResponse;
import com.joo.abysshop.entity.ProductInOrderEntity;
import com.joo.abysshop.enums.ProductType;
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

    public List<GoodsOrderResponse> filterGoodsOrders() {
        List<ProductInOrderEntity> productInOrderList =
            adminMapper.findAllProductInOrder(ProductType.GOODS);
        List<GoodsOrderResponse> goodsOrderResponseList = new ArrayList<>();

        for (ProductInOrderEntity productInOrder : productInOrderList) {
            goodsOrderResponseList.add(
                toOrderDTOMapper.toProductInOrderResponse(productInOrder));
        }

        return goodsOrderResponseList;
    }

    public void changeOrderState(Long orderId, String newState) {
        Map<String, Object> changeStateMap = new HashMap<>();
        changeStateMap.put("orderId", orderId);
        changeStateMap.put("newState", newState);

        adminMapper.changeOrderState(changeStateMap);
    }
}