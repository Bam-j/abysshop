package com.joo.abysshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/my-page")
    public String admin() {
        return "admin/adminMyPage";
    }

    @GetMapping("/admin/orderManage")
    public String orderManage() {
        return "admin/orderManage";
    }

    @GetMapping("/admin/pointManage")
    public String pointManage() {
        return "admin/pointManage";
    }

    @GetMapping("/admin/addProduct")
    public String addProduct() {
        return "admin/addProduct";
    }

    @GetMapping("/admin/removeProduct")
    public String removeProduct() {
        return "admin/removeProduct";
    }
}