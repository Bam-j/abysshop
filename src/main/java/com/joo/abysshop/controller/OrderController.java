package com.joo.abysshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

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