package com.joo.abysshop.controller;

import com.joo.abysshop.constants.ModelAttributeNames;
import com.joo.abysshop.constants.ViewNames;
import com.joo.abysshop.dto.admin.AddProductRequest;
import com.joo.abysshop.dto.order.OrderListResponse;
import com.joo.abysshop.dto.point.PointRechargeListResponse;
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
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminMyPageService adminMyPageService;
    private final AdminOrderManagementService adminOrderManagementService;
    private final AdminPointManagementService adminPointManagementService;

    @GetMapping("/admin/my-page")
    public String getAdminMyPage(@RequestParam("userId") Long userId, Model model) {
        UserType userType = adminMyPageService.getUserType(userId);

        if (userType.equals(UserType.ADMIN)) {
            List<OrderListResponse> orderList = adminOrderManagementService.getAllOrders();
            model.addAttribute(ModelAttributeNames.ORDER_LIST, orderList);

            return ViewNames.ADMIN_MY_PAGE;
        } else {
            return ViewNames.INDEX_PAGE;
        }
    }

    @GetMapping("/admin/order/list")
    public void getProductOrderList(Model model) {
        List<OrderListResponse> orderList = adminOrderManagementService.getAllOrders();
        model.addAttribute(ModelAttributeNames.ORDER_LIST, orderList);
    }

    @PostMapping("/admin/order/product/change-state")
    public RedirectView changeOrderState(@RequestParam("orderId") Long orderId,
        @RequestParam("newState") String newState, Model model) {
        adminOrderManagementService.changeOrderState(orderId, newState);

        List<OrderListResponse> orderList = adminOrderManagementService.getAllOrders();
        model.addAttribute(ModelAttributeNames.ORDER_LIST, orderList);

        return new RedirectView("admin/my-page?menu=order-management");
    }

    @GetMapping("/admin/point/recharge/list")
    public void getPointOrders(Model model) {
        List<PointRechargeListResponse> pointRechargeList = adminPointManagementService.getAllPointRecharge();
        model.addAttribute(ModelAttributeNames.POINT_RECHARGE_LIST, pointRechargeList);
    }

    @PostMapping("/admin/point/provide")
    public RedirectView providePoint(@RequestParam("userId") Long userId,
        @RequestParam("point") Long point) {
        //TODO: 지급 후 해당 항목 disabled
        adminPointManagementService.providePoint(userId, point);
        return new RedirectView("admin/my-page?menu=point-recharge-management");
    }

    @PostMapping("/admin/product/add")
    public RedirectView addProduct(@ModelAttribute AddProductRequest addProductRequest)
        throws IOException {
        //TODO: Image 관련 내용 구현하기
        adminMyPageService.addProduct(addProductRequest);
        return new RedirectView("admin/my-page?menu=add-product");

    }

    @PostMapping("/admin/product/remove")
    public RedirectView removeProduct(@RequestParam("productId") Long productId) {
        adminMyPageService.removeProduct(productId);
        return new RedirectView("admin/my-page?menu=remove-product");
    }
}