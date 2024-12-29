package com.joo.abysshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @GetMapping("/product/list/ptoducts")
    public String getProductList() {
        //TODO: products_table에서 type이 'product'인 상품들만 뽑아와서 화면에 전달
        return "";
    }

    @GetMapping("/product/list/points")
    public String getPointList() {
        //TODO: products_table에서 type이 'points'인 상품들만 뽑아와서 화면에 전달
        return "";
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