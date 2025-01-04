package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.dto.product.ProductDetailResponse;
import com.joo.abysshop.entity.ProductEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    List<ProductEntity> findAllProductItems();

    List<ProductEntity> findAllPointItems();

    ProductDetailResponse findById(Long id);

    //아래는 테스트용 매퍼 추후 삭제
    int insertProductForTest(ProductEntity productEntity);

    int selectCountByProductName(String productName);
}
