package com.joo.abysshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    /*
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
        return "user/userOrder";
    }
}