package com.joo.abysshop.service.product;

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
        List<ProductListResponse> productList = new ArrayList<>();

        if (productType.equals(ProductType.GOODS)) {
            List<ProductEntity> itemEntityList = productMapper.findAllProduct(ProductType.GOODS);

            for (ProductEntity itemEntity : itemEntityList) {
                productList.add(
                    ProductEntityToDTO.productEntityToProductListResponse(itemEntity));
            }
        } else if (productType.equals(ProductType.POINT)) {
            List<ProductEntity> pointEntityList = productMapper.findAllProduct(ProductType.POINT);

            for (ProductEntity pointEntity : pointEntityList) {
                productList.add(
                    ProductEntityToDTO.productEntityToProductListResponse(pointEntity));
            }
        }
        return productList;
    }

    public ProductDetailResponse findById(Long id) {
        return productMapper.findById(id);
    }
}