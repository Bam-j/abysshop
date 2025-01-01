package com.joo.abysshop.service;

import com.joo.abysshop.entity.ProductEntity;
import com.joo.abysshop.mapper.ProductMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public List<ProductEntity> findAllProductItems() {
        List<ProductEntity> productItemList = productMapper.findAllProductItems();
    }

    public List<ProductEntity> findAllPointItems() {
    }
}