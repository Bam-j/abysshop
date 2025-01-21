package com.joo.abysshop.controller;

import com.joo.abysshop.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/detail/{productId}")
    public String getProductDetail(@PathVariable Long productId, Model model) {
        model.addAttribute("product", productService.findById(productId));
        return "product/detail";
    }

    /*
        TODO: 배포 단계 직전에 디자인 작업용 임시 컨트롤러들 전부 삭제할 것
        디자인 작업용 임시 화면 요청
        실제 요청은 /product/detail/{id}로 사용할 것. (id는 품목 id)
     */
    @GetMapping("/product/detail")
    public String detail() {
        return "product/productDetail";
    }
}