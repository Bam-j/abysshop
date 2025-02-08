package com.joo.abysshop.controller;

import com.joo.abysshop.constants.ModelAttributeNames;
import com.joo.abysshop.constants.ViewNames;
import com.joo.abysshop.dto.admin.AddProductRequest;
import com.joo.abysshop.dto.admin.ChangeOrderStateRequest;
import com.joo.abysshop.dto.admin.ChangePointRechargeStateRequest;
import com.joo.abysshop.dto.admin.ProvidePointRequest;
import com.joo.abysshop.dto.order.OrderListResponse;
import com.joo.abysshop.dto.point.PointRechargeDetailResponse;
import com.joo.abysshop.dto.point.PointRechargeListResponse;
import com.joo.abysshop.dto.product.ProductListResponse;
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
    public String getAdminMyPage(
        @RequestParam(value = "menu", defaultValue = "order-management") String menu, Model model) {
        if ("order-management".equals(menu)) {
            List<OrderListResponse> orderList = adminOrderManagementService.getAllOrders();
            model.addAttribute(ModelAttributeNames.ORDER_LIST, orderList);
        } else if ("point-recharge-management".equals(menu)) {
            List<PointRechargeListResponse> pointRechargeList = adminPointManagementService.getAllPointRecharge();
            model.addAttribute(ModelAttributeNames.POINT_RECHARGE_LIST, pointRechargeList);
        } else if ("add-product".equals(menu)) {
        } else if ("remove-product".equals(menu)) {
            List<ProductListResponse> productList = adminMyPageService.getAllProducts();
            model.addAttribute(ModelAttributeNames.PRODUCT_LIST, productList);
        }

        return ViewNames.ADMIN_MY_PAGE;
    }

    @PostMapping("/admin/order/change-state")
    public RedirectView changeOrderState(
        @ModelAttribute ChangeOrderStateRequest changeOrderStateRequest, Model model) {
        adminOrderManagementService.changeOrderState(changeOrderStateRequest);

        List<OrderListResponse> orderList = adminOrderManagementService.getAllOrders();
        model.addAttribute(ModelAttributeNames.ORDER_LIST, orderList);

        return new RedirectView("/admin/my-page");
    }

    @PostMapping("/admin/point/provide")
    public RedirectView providePoint(@ModelAttribute ProvidePointRequest providePointRequest) {
        adminPointManagementService.providePoint(providePointRequest);
        return new RedirectView("/admin/my-page?menu=point-recharge-management");
    }

    @PostMapping("/admin/product/add")
    public RedirectView addProduct(@ModelAttribute AddProductRequest addProductRequest)
        throws IOException {
        //TODO: Image 관련 내용 구현하기
        adminMyPageService.addProduct(addProductRequest);
        return new RedirectView("/admin/my-page?menu=add-product");

    }

    @PostMapping("/admin/product/remove")
    public RedirectView removeProduct(@RequestParam("productId") Long productId) {
        adminMyPageService.removeProduct(productId);
        return new RedirectView("/admin/my-page?menu=remove-product");
    }

    @PostMapping("/admin/recharge/change-state")
    public RedirectView changePointRechargeState(
        @ModelAttribute ChangePointRechargeStateRequest changePointRechargeStateRequest,
        Model model) {
        adminPointManagementService.changePointRechargeState(changePointRechargeStateRequest);

        List<PointRechargeListResponse> pointRechargeList = adminPointManagementService.getAllPointRecharge();
        model.addAttribute(ModelAttributeNames.POINT_RECHARGE_LIST, pointRechargeList);

        return new RedirectView("/admin/my-page?menu=point-recharge-management");
    }
}