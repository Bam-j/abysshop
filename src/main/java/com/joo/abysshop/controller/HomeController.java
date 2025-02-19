package com.joo.abysshop.controller;

import com.joo.abysshop.constants.ModelAttributeNames;
import com.joo.abysshop.constants.ViewNames;
import com.joo.abysshop.dto.cart.CartResponse;
import com.joo.abysshop.dto.product.ProductListResponse;
import com.joo.abysshop.dto.user.UserInfoResponse;
import com.joo.abysshop.service.cart.CartService;
import com.joo.abysshop.service.product.ProductService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;
    private final CartService cartService;

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        List<ProductListResponse> productList = productService.findAllProducts();
        model.addAttribute(ModelAttributeNames.PRODUCT_LIST, productList);

        UserInfoResponse user = (UserInfoResponse) session.getAttribute("user");
        if (user != null) {
            CartResponse cart = cartService.getCart(user.getUserId());
            model.addAttribute(ModelAttributeNames.CART, cart);
        }

        return ViewNames.INDEX_PAGE;
    }
}