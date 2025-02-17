package com.joo.abysshop.controller;

import com.joo.abysshop.constants.Messages;
import com.joo.abysshop.constants.RedirectMappings;
import com.joo.abysshop.constants.ViewNames;
import com.joo.abysshop.dto.order.CreateOrderRequest;
import com.joo.abysshop.dto.user.UserInfoResponse;
import com.joo.abysshop.enums.ResultStatus;
import com.joo.abysshop.service.order.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order/complete")
    public String complete(HttpSession session, Model model) {
        UserInfoResponse user =  (UserInfoResponse) session.getAttribute("user");
        model.addAttribute("user", user);
        return ViewNames.ORDER_COMPLETE_PAGE;
    }

    @PostMapping("/order/create")
    public RedirectView createOrder(@ModelAttribute CreateOrderRequest createOrderRequest,
        RedirectAttributes redirectAttributes) {
        /*
            1. carts_table의 정보를 기반으로 orders_table의 레코드 생성
            2. carts_table, carts_item_table에서 해당 레코드들 삭제 (item은 delete cascade이므로 carts만 삭제)
         */
        ResultStatus createOrderResult = orderService.createOrder(createOrderRequest);

        if (createOrderResult.equals(ResultStatus.INSUFFICIENT_POINTS)) {
            redirectAttributes.addFlashAttribute(Messages.FAILURE_MESSAGE, "포인트가 부족합니다.");
            return new RedirectView("/user/cart/" + createOrderRequest.getUserId());
        }

        return new RedirectView("/order/complete");
    }
}