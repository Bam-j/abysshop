package com.joo.abysshop.service.product;

import com.joo.abysshop.dto.product.ProductDetailResponse;
import com.joo.abysshop.dto.product.ProductListResponse;
import com.joo.abysshop.entity.product.ProductEntity;
import com.joo.abysshop.mapper.dto.ToProductDTOMapper;
import com.joo.abysshop.mapper.mybatis.ProductMapper;
import java.util.ArrayList;
import java.util.List;
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
            productList.add(toProductDTOMapper.toProductListResponse(productEntity));
        }

        return productList;
    }

    public ProductDetailResponse findById(Long id) {
        ProductEntity productEntity = productMapper.findById(id);

        return toProductDTOMapper.toProductDetailResponse(productEntity);
    }
}