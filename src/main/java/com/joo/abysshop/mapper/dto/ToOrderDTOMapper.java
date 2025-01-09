package com.joo.abysshop.mapper.dto;

import com.joo.abysshop.dto.order.GoodsOrderResponse;
import com.joo.abysshop.dto.order.OrderResponse;
import com.joo.abysshop.dto.order.PointOrderResponse;
import com.joo.abysshop.entity.order.ProductInOrderEntity;
import com.joo.abysshop.enums.ProductType;

public interface ToOrderDTOMapper<T extends OrderResponse> {

    OrderResponse mapToOrderResponse(ProductInOrderEntity productInOrderEntity, ProductType productType);

    GoodsOrderResponse toGoodsOrderResponse(ProductInOrderEntity productInOrderEntity);

    PointOrderResponse toPointOrderResponse(ProductInOrderEntity productInOrderEntity);
}
