package com.joo.abysshop.controller;

import com.joo.abysshop.dto.order.CreateOrderRequest;
import com.joo.abysshop.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/create")
    public String createOrder(@ModelAttribute CreateOrderRequest createOrderRequest) {
        //장바구니 상품들 가져와서 order로 만들기 + 보유 포인트에서 총합 포인트 빼기

        orderService.createOrder(createOrderRequest);

        return "order/bankTransferInfo";
    }

    /*
        페이지 디자인 작업용으로 사용하는 임시 GET 요청.
        실제 동작은 /order/cart/{id}로 사용할 것. (id는 회원의 id)
     */

    @GetMapping("/order/complete")
    public String complete() {
        return "order/orderComplete";
    }
}