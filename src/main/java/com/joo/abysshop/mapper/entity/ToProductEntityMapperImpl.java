package com.joo.abysshop.mapper.entity;


import com.joo.abysshop.dto.admin.AddProductRequest;
import com.joo.abysshop.entity.admin.AddProductEntity;
import com.joo.abysshop.entity.product.ProductEntity;
import com.joo.abysshop.entity.product.ProductImageEntity;
import org.springframework.stereotype.Component;

@Component
public class ToProductEntityMapperImpl implements ToProductEntityMapper {

    @Override
    public ProductEntity toProductEntity(AddProductRequest addProductRequest) {
        return ProductEntity.builder()
            .productName(addProductRequest.getProductName())
            .price(addProductRequest.getPrice())
            .description(addProductRequest.getDescription())
            .build();
    }

    @Override
    public ProductImageEntity toProductImageEntity(AddProductRequest addProductRequest,
        Long productId) {
        return ProductImageEntity.builder()
            .productId(productId)
            //.image(addProductRequest.getImage()) multipart -> byte[] 변환
            .originalFileName(addProductRequest.getOriginalFileName())
            .build();
    }

    @Override
    public AddProductEntity toAddProductEntity(AddProductRequest addProductRequest) {
        return AddProductEntity.builder()
            .productName(addProductRequest.getProductName())
            .price(addProductRequest.getPrice())
            .description(addProductRequest.getDescription())
            .productType(addProductRequest.getProductType())
            .build();
    }
}
