package com.joo.abysshop.mapper;

import com.joo.abysshop.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int insertProduct(Product product);
    int selectCountByProductName(String productName);
}
