package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.dto.product.ProductDetailResponse;
import com.joo.abysshop.entity.product.ProductEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    List<ProductEntity> findAllProducts();

    ProductEntity findById(Long id);

    Long findProductIdByProductName(String productName);
}
