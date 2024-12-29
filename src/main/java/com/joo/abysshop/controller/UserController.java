package com.joo.abysshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/user/cart/{id}")
    public String getUserCartPage(@PathVariable int id, Model model) {
        //TODO: id를 통해 장바구니에 담긴 상품 목록들을 가져와서 페이지로 넘긴다.
        return "order/shoppingCart";
    }

    @GetMapping("/user/my-page/{id}")
    public String getUserMyPage(@PathVariable int id, Model model) {
        //TODO: 유저 id에 대한 정보 함께 넘기기
        //TODO: 기본 내용인 order history를 볼 수 있게 뿌려주기
        return "user/userMyPage";
    }

    /*
        TODO: 개발 완료 후 아래 요청들 삭제할 것
        디자인 작업용 임시 요청들.
        실제 요청은 /user/xxxxx/{id} 사용. (id는 회원 id)
     */
    @GetMapping("/user/my-page")
    public String myPage() {
        return "user/userMyPage";
    }

    @GetMapping("/user/info")
    public String userInfo() {
        return "user/userInfo";
    }

    @GetMapping("/user/order")
    public String userOrder() {
        return "userOrderManagement";
    }
}