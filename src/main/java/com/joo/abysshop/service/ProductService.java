package com.joo.abysshop.service;

import com.joo.abysshop.dto.product.ProductDetailResponse;
import com.joo.abysshop.mapper.dto.ProductEntityToDTO;
import com.joo.abysshop.dto.product.ProductListResponse;
import com.joo.abysshop.entity.ProductEntity;
import com.joo.abysshop.enums.ProductType;
import com.joo.abysshop.mapper.mybatis.ProductMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public List<ProductListResponse> findAllProducts(ProductType productType) {
        List<ProductListResponse> itemList = new ArrayList<>();

        if (productType.equals(ProductType.PRODUCT)) {
            List<ProductEntity> productItemEntityList = productMapper.findAllProductItems();

            for (ProductEntity entity : productItemEntityList) {
                itemList.add(
                    ProductEntityToDTO.productEntityToProductListResponse(entity));
            }
        } else if (productType.equals(ProductType.POINT)) {
            List<ProductEntity> pointItemEntityList = productMapper.findAllPointItems();

            for (ProductEntity entity : pointItemEntityList) {
                itemList.add(
                    ProductEntityToDTO.productEntityToProductListResponse(entity));
            }
        }
        return itemList;
    }

    public ProductDetailResponse findById(Long id) {
        return productMapper.findById(id);
    }
}