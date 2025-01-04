package com.joo.abysshop.mapper.dto;

import com.joo.abysshop.dto.order.ProductOrderResponse;
import com.joo.abysshop.entity.ProductInOrderEntity;
import org.springframework.stereotype.Component;

@Component
public class ToOrderDTOMapperImpl implements ToOrderDTOMapper {

    @Override
    public ProductOrderResponse toProductInOrderResponse(
        ProductInOrderEntity productInOrderEntity) {
        return ProductOrderResponse.builder()
            .userId(productInOrderEntity.getUserId())
            .productId(productInOrderEntity.getProductId())
            .orderId(productInOrderEntity.getOrderId())
            .productName(productInOrderEntity.getProductName())
            .price(productInOrderEntity.getPrice())
            .build();
    }
}
