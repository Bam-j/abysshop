package com.joo.abysshop.controller;

import com.joo.abysshop.dto.admin.AddProductRequest;
import com.joo.abysshop.dto.order.OrderListResponse;
import com.joo.abysshop.dto.point.PointRechargeListResponse;
import com.joo.abysshop.enums.JspView;
import com.joo.abysshop.enums.UserType;
import com.joo.abysshop.service.admin.AdminMyPageService;
import com.joo.abysshop.service.admin.AdminOrderManagementService;
import com.joo.abysshop.service.admin.AdminPointManagementService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminMyPageService adminMyPageService;
    private final AdminOrderManagementService adminOrderManagementService;
    private final AdminPointManagementService adminPointManagementService;

    @GetMapping("/admin/my-page")
    public String getAdminMyPage(@RequestParam("userId") Long userId) {
        UserType userType = adminMyPageService.getUserType(userId);

        if (userType.equals(UserType.ADMIN)) {
            return "admin/adminMyPage";
        } else {
            return JspView.REDIRECT.getView();
        }
    }

    @GetMapping("/admin/order/list")
    public void getProductOrderList(Model model) {
        List<OrderListResponse> orderList = adminOrderManagementService.getAllOrders();
        model.addAttribute("orderList", orderList);
    }

    @PostMapping("/admin/order/product/change-state")
    public String changeOrderState(@RequestParam("orderId") Long orderId,
        @RequestParam("newState") String newState, Model model) {
        adminOrderManagementService.changeOrderState(orderId, newState);

        List<OrderListResponse> orderList = adminOrderManagementService.getAllOrders();
        model.addAttribute("orderList", orderList);

        return JspView.REDIRECT.getView();
    }

    @GetMapping("/admin/point/recharge/list")
    public void getPointOrders(Model model) {
        List<PointRechargeListResponse> pointRechargeList = adminPointManagementService.getAllPointRecharge();
        model.addAttribute("pointRechargeList", pointRechargeList);
    }

    @PostMapping("/admin/point/provide")
    public String providePoint(@RequestParam("userId") Long userId,
        @RequestParam("point") Long point) {
        //TODO:요청 포인트를 user에게 지급 후 해당 항목 disabled
        adminPointManagementService.providePoint(userId, point);
        return JspView.REDIRECT.getView();
    }

    @PostMapping("/admin/product/add")
    public String addProduct(@ModelAttribute AddProductRequest addProductRequest)
        throws IOException {
        //TODO: Image 관련 내용 구현하기
        adminMyPageService.addProduct(addProductRequest);
        return JspView.REDIRECT.getView();
    }

    @PostMapping("/admin/product/remove")
    public String removeProduct(@RequestParam("productId") Long productId) {
        //TODO: 폼에 입력된 정보들을 토대로 products_table에서 상품 제거
        adminMyPageService.removeProduct(productId);
        return JspView.REDIRECT.getView();
    }
}