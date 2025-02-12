package com.joo.abysshop.service.product;

import com.joo.abysshop.dto.product.ProductDetailResponse;
import com.joo.abysshop.dto.product.ProductListResponse;
import com.joo.abysshop.entity.product.ProductEntity;
import com.joo.abysshop.entity.product.ProductImageEntity;
import com.joo.abysshop.mapper.dto.ToProductDTOMapper;
import com.joo.abysshop.mapper.mybatis.ProductMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ToProductDTOMapper toProductDTOMapper;

    public List<ProductListResponse> findAllProducts() {
        List<ProductEntity> productEntityList = productMapper.findAllProducts();
        List<ProductListResponse> productList = new ArrayList<>();

        for (ProductEntity productEntity : productEntityList) {
            Long productId = productEntity.getProductId();
            Optional<ProductImageEntity> optionalProductImageEntity = productMapper.findProductImageEntityByProductId(
                productId);

            if (optionalProductImageEntity.isPresent()) {
                ProductImageEntity productImageEntity = optionalProductImageEntity.get();
                String originalFileName = productImageEntity.getOriginalFileName();

                productList.add(
                    toProductDTOMapper.toProductListResponseWithImage(productEntity,
                        originalFileName));
            } else {
                productList.add(toProductDTOMapper.toProductListResponse(productEntity));
            }
        }

        return productList;
    }

    public ProductDetailResponse findById(Long productId) {
        ProductEntity productEntity = productMapper.findById(productId);

        return toProductDTOMapper.toProductDetailResponse(productEntity);
    }
}