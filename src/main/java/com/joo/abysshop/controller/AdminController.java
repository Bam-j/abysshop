package com.joo.abysshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/my-page")
    public String getAdminMyPage() {
        //TODO: URL 요청을 방지하기 위해 접근자가 admin 권한이 있는지 검사 후 return
        return "admin/adminMyPage";
    }


    /*
        TODO: 개발 완료 후 아래 요청들 삭제할 것
        디자인 작업용 임시 요청들.
     */
    @GetMapping("/admin/my-page")
    public String admin() {
        return "admin/adminMyPage";
    }

    @GetMapping("/admin/orderManage")
    public String orderManage() {
        return "orderManagement";
    }

    @GetMapping("/admin/pointManage")
    public String pointManage() {
        return "pointManagement";
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