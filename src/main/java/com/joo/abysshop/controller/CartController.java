package com.joo.abysshop.controller;

import com.joo.abysshop.dto.cart.UserCartItemResponse;
import com.joo.abysshop.dto.cart.UserCartResponse;
import com.joo.abysshop.service.cart.CartService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/user/cart/{id}")
    public String getUserCartPage(@PathVariable Long userId, Model model) {
        //TODO: id를 통해 장바구니에 담긴 상품 목록들을 가져와서 페이지로 넘긴다.
        UserCartResponse userCart = cartService.getUserCart(userId);
        List<UserCartItemResponse> userCartItems = cartService.getUserCartItems();

        model.addAttribute("userCartItems", userCartItems);
        model.addAttribute("userCartInfo", userCart);
        return "order/shoppingCart";
    }

    @PostMapping("/cart/remove/item")
    public void removeItem(Model model) {
        //TODO: 카트 아이템 삭제 후 model에 정보 다시 불러오기
    }

    /*
        페이지 디자인 작업용으로 사용하는 임시 GET 요청.
        실제 동작은 /order/cart/{id}로 사용할 것. (id는 회원의 id)
     */
    @GetMapping("/cart")
    public String cart() {
        return "order/shoppingCart";
    }
}
