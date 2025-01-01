package com.joo.abysshop.controller;

import com.joo.abysshop.entity.ProductEntity;
import com.joo.abysshop.mapper.ProductMapper;
import com.joo.abysshop.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;
    private final ProductService productService;

    @GetMapping("/product/list/product")
    public void getProductList(Model model) {
        List<ProductEntity> productItemList = productService.findAllProductItems();
        model.addAttribute("productItemList", productItemList);
    }

    @GetMapping("/product/list/point")
    public void getPointList(Model model) {
        List<ProductEntity> pointItemList = productService.findAllPointItems();
        model.addAttribute("pointItemList", pointItemList);
    }

    @GetMapping("/product/detail/{id}")
    public String getProductDetail(@PathVariable int id, Model model) {
        //TODO: 상품을 찾아서 detail 페이지로 이동
        return "product/detail";
    }

    /*
        디자인 작업용 임시 화면 요청
        실제 요청은 /product/detail/{id}로 사용할 것. (id는 품목 id)
     */
    @GetMapping("/product/detail")
    public String detail() {
        return "product/productDetail";
    }
}