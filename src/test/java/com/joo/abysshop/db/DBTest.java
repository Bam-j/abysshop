package com.joo.abysshop.db;

import com.joo.abysshop.entity.ProductEntity;
import com.joo.abysshop.enums.ProductType;
import com.joo.abysshop.mapper.mybatis.ProductMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DBTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    @DisplayName("products_table insert 수행 테스트")
    void DBProductsTableInsertTest() {
        //given
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName("새로운 상품");
        productEntity.setPrice(10000L);
        productEntity.setDescription("상품 설명");
        productEntity.setProductType(ProductType.GOODS);

        //when
        productMapper.insertProductForTest(productEntity);

        //then
        int count = productMapper.selectCountByProductName(productEntity.getProductName());
        assertEquals(1, count, "삽입된 레코드의 개수가 1개가 아닙니다.");
    }
}