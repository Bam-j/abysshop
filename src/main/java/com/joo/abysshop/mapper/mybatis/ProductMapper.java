package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.dto.product.ProductDetailResponse;
import com.joo.abysshop.entity.ProductEntity;
import com.joo.abysshop.enums.ProductType;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    List<ProductEntity> findAllProduct(ProductType productType);

    ProductDetailResponse findById(Long id);
}
