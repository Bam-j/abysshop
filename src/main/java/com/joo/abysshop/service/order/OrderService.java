package com.joo.abysshop.service.order;

import com.joo.abysshop.dto.order.CreateOrderRequest;
import com.joo.abysshop.entity.order.CreateOrderEntity;
import com.joo.abysshop.mapper.mybatis.OrderMapper;
import com.joo.abysshop.mapper.mybatis.UserMapper;
import com.joo.abysshop.service.cart.CartService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CartService cartService;
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;

    public void createOrder(CreateOrderRequest createOrderRequest) {
        Long cartId = createOrderRequest.getCartId();
        Long userId = createOrderRequest.getUserId();
        Long totalPoints = cartService.getTotalPoints(cartId);
        Long userPoints = userMapper.getUserPoints(userId);

        if (userPoints < totalPoints) {
            //TODO: 프론트에 응답 보내고 실패 메세지 띄우기
            return;
        }

        CreateOrderEntity createOrderEntity = CreateOrderEntity.builder()
            .userId(userId)
            .totalPoints(totalPoints)
            .build();
        orderMapper.insertOrder(createOrderEntity);

        Long remainPoints = userPoints - totalPoints;
        Map<String, Object> remainPointsMap = new HashMap<>();
        remainPointsMap.put("userId", userId);
        remainPointsMap.put("remainPoints", remainPoints);
        userMapper.consumePoint(remainPointsMap);
    }
}
