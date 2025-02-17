package com.joo.abysshop.controller;

import com.joo.abysshop.constants.RedirectMappings;
import com.joo.abysshop.constants.ViewNames;
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

    @GetMapping("/order/complete")
    public String complete() {
        return ViewNames.ORDER_COMPLETE_PAGE;
    }

    @PostMapping("/order/create")
    public String createOrder(@ModelAttribute CreateOrderRequest createOrderRequest) {
        /*
            1. carts_table의 정보를 기반으로 orders_table의 레코드 생성
            2. carts_table, carts_item_table에서 해당 레코드들 삭제 (item은 delete cascade이므로 carts만 삭제)
         */
        orderService.createOrder(createOrderRequest);

        return RedirectMappings.REDIRECT_ORDER_COMPLETE;
    }
}