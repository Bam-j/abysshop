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
        return "product/productDetail";
    }
}