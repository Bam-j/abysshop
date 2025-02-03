package com.joo.abysshop.controller;

import com.joo.abysshop.constants.ModelAttributeNames;
import com.joo.abysshop.constants.ViewNames;
import com.joo.abysshop.dto.order.OrderListResponse;
import com.joo.abysshop.dto.point.PointRechargeListResponse;
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

    @GetMapping("/user/my-page/{userId}")
    public String getUserMyPage(@PathVariable("userId") Long userId,
        @RequestParam("menu") String menu, Model model) {
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

    @GetMapping("/user/my-page/{userId}/order/list")
    public String getUserMyPageOrderList(@PathVariable("userId") Long userId, Model model) {
        List<OrderListResponse> userOrderList = userService.getOrderList(userId);
        model.addAttribute(ModelAttributeNames.USER_ORDER_LIST, userOrderList);

        return "user/userOrderList";
    }

    @GetMapping("/user/my-page/{userId}/point/recharge/list")
    public String getUserMyPagePointRecharge(@PathVariable("userId") Long userId, Model model) {
        List<PointRechargeListResponse> userPointRechargeList = userService.getPointRechargeList(
            userId);
        model.addAttribute(ModelAttributeNames.USER_POINT_RECHARGE_LIST, userPointRechargeList);

        return "user/userPointRechargeList";
    }

    @GetMapping("/user/my-page/info")
    public String getUserMyPageInfo() {
        return "user/userInfo";
    }
}