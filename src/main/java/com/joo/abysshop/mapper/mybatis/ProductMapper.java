package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.entity.product.ProductEntity;
import com.joo.abysshop.entity.product.ProductImageEntity;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    List<ProductEntity> findAllProducts();

    ProductEntity findById(Long id);

    Long findProductIdByProductName(String productName);

    Optional<ProductImageEntity> findProductImageEntityByProductId(Long productId);
}
