package com.joo.abysshop.controller;

import com.joo.abysshop.dto.order.OrderResponse;
import com.joo.abysshop.enums.JspView;
import com.joo.abysshop.enums.ProductType;
import com.joo.abysshop.enums.UserType;
import com.joo.abysshop.service.admin.AdminMyPageService;
import com.joo.abysshop.service.admin.AdminOrderManagementService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminMyPageService adminMyPageService;
    private final AdminOrderManagementService adminOrderManagementService;

    @GetMapping("/admin/my-page")
    public String getAdminMyPage(@RequestParam("userId") Long userId) {
        UserType userType = adminMyPageService.getUserType(userId);

        if (userType.equals(UserType.ADMIN)) {
            return "admin/adminMyPage";
        } else {
            return JspView.HOME.getView();
        }
    }

    @GetMapping("/admin/order/goods")
    public void getGoodsOrders(Model model) {
        List<OrderResponse> goodsOrderList = adminOrderManagementService.filterOrders(
            ProductType.GOODS);
        model.addAttribute("goodsOrderList", goodsOrderList);
    }

    @PostMapping("/admin/order/goods/change-state")
    public String changeOrderState(@RequestParam("orderId") Long orderId,
        @RequestParam("newState") String newState) {
        adminOrderManagementService.changeOrderState(orderId, newState);
        return JspView.REDIRECT.getView();
    }

    @GetMapping("/admin/order/point")
    public void getPointOrders(Model model) {
        List<OrderResponse> pointOrderList = adminOrderManagementService.filterOrders(
            ProductType.POINT);
        model.addAttribute("pointOrderList", pointOrderList);
    }

    @PostMapping("/admin/order/point/provide")
    public String providePoint() {
        //TODO: JSP와 JAVA 설계 변경이 필요해보임.
        //TODO: orders에서 type이 point인 항목만 뺀 뒤 요청 포인트를 user에게 지급 후 해당 항목 disabled
        return JspView.REDIRECT.getView();
    }

    @PostMapping("/admin/product/add")
    public String addProduct() {
        //TODO: 폼에 입력된 정보들을 토대로 products_table에 데이터 추가
        return JspView.REDIRECT.getView();
    }

    @PostMapping("/admin/product/remove")
    public String removeProduct() {
        //TODO: 폼에 입력된 정보들을 토대로 products_table에서 상품 제거
        return JspView.REDIRECT.getView();
    }
}