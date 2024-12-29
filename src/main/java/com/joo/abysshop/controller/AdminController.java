package com.joo.abysshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @GetMapping("/admin/my-page")
    public String getAdminMyPage() {
        //TODO: URL 요청을 방지하기 위해 접근자가 admin 권한이 있는지 검사 후 return
        return "admin/adminMyPage";
    }

    @GetMapping("/admin/order/history")
    public String getProductOrderHistory() {
        //TODO: orders_table에서 type이 'product'인 항목 전체 가져오기
        return "";
    }

    @PostMapping("/admin/order/change-state")
    public String changeOrderState(@RequestParam("value") String selectedValue) {
        //TODO: selectedValue를 해당 주문의 state에 적용시키기
        return "redirect:/";
    }

    @GetMapping("/admin/order/point")
    public String getPointIssueRequests() {
        //TODO: orders_table에서 type이 'point'인 항목 전체 가져오기
        return "";
    }

    @PostMapping("/admin/point/issue")
    public String issuePoint() {
        //TODO: JSP와 JAVA 설계 변경이 필요해보임.
        //TODO: orders에서 type이 point인 항목만 뺀 뒤 요청 포인트를 user에게 지급 후 해당 항목 disabled
        return "redirect:/";
    }

    @PostMapping("/admin/product/add")
    public String addProduct() {
        //TODO: 폼에 입력된 정보들을 토대로 products_table에 데이터 추가
        return "redirect:/";
    }

    @PostMapping("/admin/product/remove")
    public String removeProduct() {
        //TODO: 폼에 입력된 정보들을 토대로 products_table에서 상품 제거
        return "redirect:/";
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
    public String addProductPage() {
        return "admin/addProduct";
    }

    @GetMapping("/admin/removeProduct")
    public String removeProductPage() {
        return "admin/removeProduct";
    }
}