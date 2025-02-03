package com.joo.abysshop.controller;

import com.joo.abysshop.constants.ModelAttributeNames;
import com.joo.abysshop.constants.RedirectMappings;
import com.joo.abysshop.constants.ViewNames;
import com.joo.abysshop.dto.point.CreatePointRechargeRequest;
import com.joo.abysshop.dto.point.PointRechargeDetailResponse;
import com.joo.abysshop.dto.point.PointRechargeListResponse;
import com.joo.abysshop.dto.point.SavePointRechargeDetailRequest;
import com.joo.abysshop.service.admin.AdminPointManagementService;
import com.joo.abysshop.service.point.PointRechargeManagementService;
import com.joo.abysshop.service.point.PointRechargeService;
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
public class PointController {

    private final PointRechargeService pointRechargeService;
    private final PointRechargeManagementService pointRechargeManagementService;
    private final AdminPointManagementService adminPointManagementService;

    @PostMapping("/point/recharge/request")
    public String createPointRecharge(
        @ModelAttribute CreatePointRechargeRequest createPointRechargeRequest) {
        pointRechargeService.createPointRecharge(createPointRechargeRequest);
        return RedirectMappings.REDIRECT_ORDER_COMPLETE;
    }

    @PostMapping("/point/recharge/change-state")
    public RedirectView changePointRechargeState(@RequestParam("rechargeId") Long rechargeId,
        @RequestParam("newState") String newState, Model model) {
        pointRechargeService.changePointRechargeState(rechargeId, newState);

        List<PointRechargeListResponse> pointRechargeList = adminPointManagementService.getAllPointRecharge();
        model.addAttribute(ModelAttributeNames.POINT_RECHARGE_LIST, pointRechargeList);

        return new RedirectView("/admin/my-page?menu=point-recharge-management");
    }

    @GetMapping("/point/recharge/request/detail")
    public void getPointRechargeDetail(@RequestParam("rechargeId") Long rechargeId, Model model) {
        PointRechargeDetailResponse pointRechargeDetail = pointRechargeManagementService.getDetail(
            rechargeId);

        if (pointRechargeDetail != null) {
            model.addAttribute(ModelAttributeNames.POINT_RECHARGE_DETAIL, pointRechargeDetail);
        }
    }

    @PostMapping("/point/recharge/request/detail")
    public RedirectView managePointRechargeDetail(
        @ModelAttribute SavePointRechargeDetailRequest savePointRechargeDetailRequest) {
        pointRechargeManagementService.saveDetail(savePointRechargeDetailRequest);
        return new RedirectView("/admin/my-page?menu=point-recharge-management");
    }
}
