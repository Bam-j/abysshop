package com.joo.abysshop.mapper.dto;

import com.joo.abysshop.dto.order.GoodsOrderResponse;
import com.joo.abysshop.dto.order.OrderResponse;
import com.joo.abysshop.dto.order.PointOrderResponse;
import com.joo.abysshop.entity.order.ProductInOrderEntity;
import com.joo.abysshop.enums.ProductType;
import org.springframework.stereotype.Component;

@Component
public class ToOrderDTOMapperImpl implements ToOrderDTOMapper<OrderResponse> {

    @Override
    public OrderResponse mapToOrderResponse(ProductInOrderEntity productInOrderEntity,
        ProductType productType) {
        if (productType == ProductType.GOODS) {
            return toGoodsOrderResponse(productInOrderEntity);
        } else if (productType == ProductType.POINT) {
            return toPointOrderResponse(productInOrderEntity);
        } else {
            throw new IllegalArgumentException("잘못된 ProductType: " + productType);
        }
    }

    @Override
    public GoodsOrderResponse toGoodsOrderResponse(ProductInOrderEntity productInOrderEntity) {
        return GoodsOrderResponse.builder()
            .userId(productInOrderEntity.getUserId())
            .productId(productInOrderEntity.getProductId())
            .orderId(productInOrderEntity.getOrderId())
            .productName(productInOrderEntity.getProductName())
            .price(productInOrderEntity.getPrice())
            .build();
    }

    @Override
    public PointOrderResponse toPointOrderResponse(ProductInOrderEntity productInOrderEntity) {
        return PointOrderResponse.builder()
            .userId(productInOrderEntity.getUserId())
            .productId(productInOrderEntity.getProductId())
            .orderId(productInOrderEntity.getOrderId())
            .price(productInOrderEntity.getPrice())
            .build();
    }
}
