package com.joo.abysshop.db;

import com.joo.abysshop.entity.Product;
import com.joo.abysshop.mapper.ProductMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
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
        Product product = new Product();
        product.setProductname("새로운 상품");
        product.setPrice(10000);
        product.setDescription("상품 설명");
        product.setType("product");

        //when
        productMapper.insertProduct(product);

        //then
        int count = productMapper.selectCountByProductName(product.getProductname());
        assertEquals(1, count, "삽입된 레코드의 개수가 1개가 아닙니다.");
    }
}