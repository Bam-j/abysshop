package com.joo.abysshop.mapper.dto;

import com.joo.abysshop.dto.product.ProductDetailResponse;
import com.joo.abysshop.dto.product.ProductListResponse;
import com.joo.abysshop.entity.product.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ToProductDTOMapperImpl implements ToProductDTOMapper {

    @Override
    public ProductListResponse toProductListResponse(ProductEntity productEntity) {
        return ProductListResponse.builder()
            .productId(productEntity.getProductId())
            .productName(productEntity.getProductName())
            .price(productEntity.getPrice())
            //.image() TODO: 이미지 변환 구현
            .build();
    }

    @Override
    public ProductDetailResponse toProductDetailResponse(ProductEntity productEntity) {
        return ProductDetailResponse.builder()
            .productId(productEntity.getProductId())
            .productName(productEntity.getProductName())
            .price(productEntity.getPrice())
            .description(productEntity.getDescription())
            //.image()
            .build();
    }
}
