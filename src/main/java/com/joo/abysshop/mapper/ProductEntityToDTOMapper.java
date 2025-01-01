package com.joo.abysshop.mapper;

import com.joo.abysshop.dto.product.ProductItemListResponseDTO;
import com.joo.abysshop.entity.ProductEntity;

public class ProductEntityToDTOMapper {

    public ProductItemListResponseDTO ProductEntityToDTO(ProductEntity productEntity) {
        ProductItemListResponseDTO productItemListResponseDTO = ProductItemListResponseDTO.builder()
            .productId(productEntity.getProductId())
            .productName(productEntity.getProductName())
            .price(productEntity.getPrice())
            //.image()
            .build();

        return productItemListResponseDTO;
    }
}
