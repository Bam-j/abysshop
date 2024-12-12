package com.joo.abysshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/account/sign-in")
    public String signIn() {
        return "account/signIn";
    }

    @GetMapping("/account/sign-up")
    public String signUp() {
        return "account/signUp";
    }
}