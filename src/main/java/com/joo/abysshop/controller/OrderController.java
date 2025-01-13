package com.joo.abysshop.controller;

import com.joo.abysshop.dto.cart.UserCartItemResponse;
import com.joo.abysshop.mapper.mybatis.CartMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final CartMapper cartMapper;

    @GetMapping("/order/cart/{userId}")
    public String cart(@PathVariable Long userId, Model model) {
        //TODO: JSP에서 product_type에 따라서 분리해서 보여주도록 만들기
        List<UserCartItemResponse> userCartItemResponseList = cartMapper.findAllItems(userId);
        Long cartId = cartMapper.getCartId(userId);
        model.addAttribute("userOrders", userCartItemResponseList);
        model.addAttribute("cartId", cartId);

        return "order/shoppingCart";
    }

    @PostMapping("/order/cart/remove/item")
    public String removeItem(@PathVariable Long productId, Model model) {
        //cart에서 상품 제거하고, 카트 리스트를 다시 불러와서 redirect

        return "redirect:/order/shoppingCart/" + productId;
    }

    @PostMapping("/order/create")
    public String createOrder() {
        //장바구니 상품들 가져와서 order로 만들기
        return "order/bankTransferInfo";
    }

    /*
        페이지 디자인 작업용으로 사용하는 임시 GET 요청.
        실제 동작은 /order/cart/{id}로 사용할 것. (id는 회원의 id)
     */
    @GetMapping("/order/cart")
    public String cart() {
        return "order/shoppingCart";
    }

    @GetMapping("/order/bank-transfer")
    public String bankTransfer() {
        return "order/bankTransferInfo";
    }

    @GetMapping("/order/complete")
    public String complete() {
        return "order/orderComplete";
    }
}