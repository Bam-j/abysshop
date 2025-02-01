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

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //주문 기록(default), 포인트 요청 기록, 유저 정보 수정 페이지 요청
    @GetMapping("/user/my-page/{userId}")
    public String getUserMyPage(@PathVariable("userId") Long userId, Model model) {
        List<OrderListResponse> userOrderList = userService.getOrderList(userId);
        model.addAttribute(ModelAttributeNames.USER_ORDER_LIST, userOrderList);

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