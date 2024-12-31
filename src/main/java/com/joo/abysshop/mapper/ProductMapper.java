package com.joo.abysshop.mapper;

import com.joo.abysshop.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int insertProduct(ProductEntity productEntity);
    int selectCountByProductName(String productName);
}
