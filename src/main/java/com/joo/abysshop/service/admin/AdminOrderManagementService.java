package com.joo.abysshop.service.admin;

import com.joo.abysshop.dto.order.OrderResponse;
import com.joo.abysshop.entity.order.ProductInOrderEntity;
import com.joo.abysshop.entity.user.UserEntity;
import com.joo.abysshop.enums.ProductType;
import com.joo.abysshop.mapper.dto.ToOrderDTOMapper;
import com.joo.abysshop.mapper.mybatis.AdminMapper;
import com.joo.abysshop.mapper.mybatis.UserMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminOrderManagementService {

    private final AdminMapper adminMapper;
    private final UserMapper userMapper;

    private final ToOrderDTOMapper<OrderResponse> toOrderDTOMapper;

    public List<OrderResponse> filterOrders(ProductType productType) {
        List<ProductInOrderEntity> productInOrderList =
            adminMapper.findAllProductInOrder(productType.toString());
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

    public void providePoint(Long userId, Long point) {
        Optional<UserEntity> optionalUserEntity = userMapper.findByUserId(userId);
        UserEntity userEntity;

        if (optionalUserEntity.isPresent()) {
            userEntity = optionalUserEntity.get();
        } else {
            return;
        }

        adminMapper.providePoint(userEntity.getUserId(), point);
    }
}