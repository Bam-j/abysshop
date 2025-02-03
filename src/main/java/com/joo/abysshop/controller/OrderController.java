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
        orderService.createOrder(createOrderRequest);

        return RedirectMappings.REDIRECT_ORDER_COMPLETE;
    }
}