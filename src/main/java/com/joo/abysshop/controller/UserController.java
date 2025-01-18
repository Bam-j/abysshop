package com.joo.abysshop.controller;

import com.joo.abysshop.dto.order.UserOrderResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/user/my-page/{id}")
    public String getUserMyPage(@PathVariable int id, Model model) {
        //TODO: 유저 id에 대한 정보 함께 넘기기
        //TODO: 기본 내용인 order history를 볼 수 있게 뿌려주기
        return "user/userMyPage";
    }

    @GetMapping("/user/order/history")
    public String getUserOrderHistory(int id, Model model) {
        //TODO: 회원 id 기반으로 주문 기록을 찾음
        return "";
    }
}