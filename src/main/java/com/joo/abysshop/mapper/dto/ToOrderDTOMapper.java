package com.joo.abysshop.mapper.dto;

import com.joo.abysshop.dto.order.GoodsOrderResponse;
import com.joo.abysshop.entity.ProductInOrderEntity;

public interface ToOrderDTOMapper {

    GoodsOrderResponse toProductInOrderResponse(
        ProductInOrderEntity productInOrderEntity);
}
