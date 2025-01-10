package com.joo.abysshop.mapper.entity;

import com.joo.abysshop.dto.admin.AddProductRequest;
import com.joo.abysshop.entity.admin.AddProductEntity;
import com.joo.abysshop.entity.product.ProductEntity;
import com.joo.abysshop.entity.product.ProductImageEntity;

public interface ToProductEntityMapper {

    ProductEntity toProductEntity(AddProductRequest addProductRequest);

    ProductImageEntity toProductImageEntity(AddProductRequest addProductRequest, Long productId);

    AddProductEntity toAddProductEntity(AddProductRequest addProductRequest);
}
