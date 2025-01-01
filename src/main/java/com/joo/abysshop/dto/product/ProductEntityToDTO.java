package com.joo.abysshop.dto.product;

import com.joo.abysshop.entity.ProductEntity;

public class ProductEntityToDTO {

    public static ProductListResponse productEntityToProductListResponse(
        ProductEntity productEntity) {
        ProductListResponse productListResponse = ProductListResponse.builder()
            .productId(productEntity.getProductId())
            .productName(productEntity.getProductName())
            .price(productEntity.getPrice())
            //.image() byte[] to MultipartFile 정의하기
            .build();

        return productListResponse;
    }
}
