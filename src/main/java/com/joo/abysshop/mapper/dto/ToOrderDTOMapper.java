package com.joo.abysshop.mapper.dto;

import com.joo.abysshop.dto.order.ProductOrderResponse;
import com.joo.abysshop.entity.ProductInOrderEntity;

public interface ToOrderDTOMapper {

    ProductOrderResponse toProductInOrderResponse(
        ProductInOrderEntity productInOrderEntity);
}
