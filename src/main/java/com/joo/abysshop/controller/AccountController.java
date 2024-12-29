package com.joo.abysshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @GetMapping("/account/sign-in")
    public String getSignInPage() {
        return "account/signIn";
    }

    @GetMapping("/account/sign-up")
    public String getSignUpPage() {
        return "account/signUp";
    }

    @PostMapping("/account/change/nickname")
    public String changeNickname(@RequestParam("nickname") String nickname, Model model) {
        //TODO: id로 user 탐색 후 nickname 변경
        return "redirect:/";
    }

    @PostMapping("/account/change/password")
    public String changePassword(@RequestParam("password") String password, Model model) {
        //TODO: id로 user 탐색 후 password 변경
        return "redirect:/";
    }

    @PostMapping("/account/logout")
    public String logout() {
        //TODO: 로그아웃 작업
        return "/";
    }

    @PostMapping("/account/withdraw")
    public String withdraw(@RequestParam("password") String password) {
        /*
        * TODO: 1. 입력된 비밀 번호 검증 > 로그아웃 > 계정 삭제 > 홈으로 이동
         */
        return "/";
    }

}