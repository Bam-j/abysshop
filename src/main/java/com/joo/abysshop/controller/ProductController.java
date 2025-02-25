package com.joo.abysshop.controller;

import com.joo.abysshop.constants.ModelAttributeNames;
import com.joo.abysshop.constants.ViewNames;
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
        //TODO: filename 가져오는 로직 누락으로 detail 페이지에서 이미지가 나타나지 않음.
        model.addAttribute(ModelAttributeNames.PRODUCT, productService.findById(productId));
        return ViewNames.PRODUCT_DETAIL_PAGE;
    }
}