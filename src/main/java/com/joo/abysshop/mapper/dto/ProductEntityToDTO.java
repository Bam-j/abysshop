package com.joo.abysshop.mapper.dto;

import com.joo.abysshop.dto.product.ProductListResponse;
import com.joo.abysshop.entity.product.ProductEntity;

public class ProductEntityToDTO {

    public static ProductListResponse productEntityToProductListResponse(
        ProductEntity productEntity) {
        return ProductListResponse.builder()
            .productId(productEntity.getProductId())
            .productName(productEntity.getProductName())
            .price(productEntity.getPrice())
            //.image() byte[] to MultipartFile 정의하기
            .build();
    }
}
