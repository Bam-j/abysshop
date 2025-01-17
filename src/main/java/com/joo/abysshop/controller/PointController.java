package com.joo.abysshop.controller;

import com.joo.abysshop.dto.point.CreatePointRechargeRequest;
import com.joo.abysshop.dto.point.PointRechargeDetailResponse;
import com.joo.abysshop.dto.point.PointRechargeListResponse;
import com.joo.abysshop.dto.point.SavePointRechargeDetailRequest;
import com.joo.abysshop.enums.JspView;
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

@Controller
@RequiredArgsConstructor
public class PointController {

    private final PointRechargeService pointRechargeService;
    private final PointRechargeManagementService pointRechargeManagementService;
    private final AdminPointManagementService adminPointManagementService;

    @PostMapping("/point/recharge/request")
    public String createPointRecharge(
        @ModelAttribute CreatePointRechargeRequest createPointRechargeRequest) {
        //TODO: 입력 유효값 검사 등은 프론트 스크립트에서 수행
        pointRechargeService.createPointRecharge(createPointRechargeRequest);
        return "order/orderComplete";
    }

    @PostMapping("/point/recharge/change-state")
    public String changePointRechargeState(@RequestParam("rechargeId") Long rechargeId,
        @RequestParam("newState") String newState, Model model) {
        pointRechargeService.changePointRechargeState(rechargeId, newState);

        List<PointRechargeListResponse> pointRechargeList = adminPointManagementService.getAllPointRecharge();
        model.addAttribute("pointRechargeList", pointRechargeList);

        return JspView.REDIRECT.getView();
    }

    @GetMapping("/point/recharge/request/detail")
    public void getPointRechargeDetail(@RequestParam("rechargeId") Long rechargeId, Model model) {
        PointRechargeDetailResponse pointRechargeDetailResponse = pointRechargeManagementService.getDetail(
            rechargeId);

        if (pointRechargeDetailResponse != null) {
            model.addAttribute("pointRechargeDetail", pointRechargeDetailResponse);
        }
    }

    @PostMapping("/point/recharge/request/detail")
    public String managePointRechargeDetail(
        @ModelAttribute SavePointRechargeDetailRequest savePointRechargeDetailRequest) {
        pointRechargeManagementService.saveDetail(savePointRechargeDetailRequest);
        return JspView.REDIRECT.getView();
    }
}
