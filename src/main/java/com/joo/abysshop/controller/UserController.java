package com.joo.abysshop.controller;

import com.joo.abysshop.constants.ModelAttributeNames;
import com.joo.abysshop.constants.ViewNames;
import com.joo.abysshop.dto.cart.CartResponse;
import com.joo.abysshop.dto.order.OrderListResponse;
import com.joo.abysshop.dto.point.PointRechargeListResponse;
import com.joo.abysshop.dto.user.UserInfoResponse;
import com.joo.abysshop.service.cart.CartService;
import com.joo.abysshop.service.user.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CartService cartService;

    @GetMapping("/user/my-page/{userId}")
    public String getUserMyPage(@PathVariable("userId") Long userId,
        @RequestParam("menu") String menu, Model model) {
        CartResponse cart = cartService.getCart(userId);
        model.addAttribute(ModelAttributeNames.CART, cart);

        if ("order-management".equals(menu)) {
            List<OrderListResponse> userOrderList = userService.getOrderList(userId);
            model.addAttribute(ModelAttributeNames.USER_ORDER_LIST, userOrderList);
        } else if ("user-info".equals(menu)) {
            // 계정 관리 페이지 처리 로직
        } else if ("point-request".equals(menu)) {
            List<PointRechargeListResponse> userPointRechargeList = userService.getPointRechargeList(
                userId);
            model.addAttribute(ModelAttributeNames.USER_POINT_RECHARGE_LIST, userPointRechargeList);
        } else {
            // 잘못된 메뉴 요청 처리 로직
        }
        return ViewNames.USER_MY_PAGE;
    }
}