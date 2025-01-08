package com.joo.abysshop.mapper.entity;

import com.joo.abysshop.dto.admin.AddProductRequest;
import com.joo.abysshop.entity.AddProductEntity;
import com.joo.abysshop.entity.ProductEntity;
import com.joo.abysshop.entity.ProductImageEntity;
import org.springframework.stereotype.Component;

@Component
public interface ToProductEntityMapper {

    ProductEntity toProductEntity(AddProductRequest addProductRequest);

    ProductImageEntity toProductImageEntity(AddProductRequest addProductRequest, Long productId);

    AddProductEntity toAddProductEntity(AddProductRequest addProductRequest);
}
