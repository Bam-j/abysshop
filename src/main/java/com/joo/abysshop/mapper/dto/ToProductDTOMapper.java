package com.joo.abysshop.mapper.dto;

import com.joo.abysshop.dto.product.ProductDetailResponse;
import com.joo.abysshop.dto.product.ProductListResponse;
import com.joo.abysshop.entity.product.ProductEntity;

public interface ToProductDTOMapper {

    ProductListResponse toProductListResponse(ProductEntity productEntity);

    ProductDetailResponse toProductDetailResponse(ProductEntity productEntity);
}
