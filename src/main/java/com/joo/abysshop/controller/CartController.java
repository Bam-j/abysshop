package com.joo.abysshop.controller;

import com.joo.abysshop.dto.cart.CartItemResponse;
import com.joo.abysshop.dto.cart.CartResponse;
import com.joo.abysshop.dto.cart.RemoveItemRequest;
import com.joo.abysshop.service.cart.CartService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/user/cart/{userId}")
    public String getUserCartPage(@PathVariable("userId") Long userId, Model model) {
        CartResponse userCart = cartService.getCart(userId);

        Long cartId = userCart.getCartId();
        List<CartItemResponse> userCartItems = cartService.getUserCartItems(cartId);

        model.addAttribute("userCartItems", userCartItems);
        model.addAttribute("userCartInfo", userCart);
        return "cart/shoppingCart";
    }

    @PostMapping("/cart/item/remove")
    public RedirectView removeItem(@ModelAttribute RemoveItemRequest removeItemRequest, Model model) {
        cartService.removeItem(removeItemRequest);

        Long userId = removeItemRequest.getUserId();
        CartResponse userCart = cartService.getCart(userId);

        Long cartId = userCart.getCartId();
        List<CartItemResponse> userCartItems = cartService.getUserCartItems(cartId);

        model.addAttribute("userCartItems", userCartItems);
        model.addAttribute("userCartInfo", userCart);

        return new RedirectView("/user/cart/" + userId);
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
