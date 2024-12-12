package com.joo.abysshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/product/product-purchase")
    public String productPurchase() {
        return "product/productPurchases";
    }

    @GetMapping("/product/point-purchase")
    public String pointPurchase() {
        return "product/pointPurchase";
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