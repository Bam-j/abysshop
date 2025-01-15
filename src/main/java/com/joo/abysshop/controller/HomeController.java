package com.joo.abysshop.controller;

import com.joo.abysshop.dto.product.ProductListResponse;
import com.joo.abysshop.enums.JspView;
import com.joo.abysshop.service.product.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        List<ProductListResponse> productList = productService.findAllProducts();
        model.addAttribute("productList", productList);

        return JspView.HOME.getView();
    }
}