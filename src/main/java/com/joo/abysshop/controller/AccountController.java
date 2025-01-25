package com.joo.abysshop.controller;

import com.joo.abysshop.dto.account.AccountSignInRequest;
import com.joo.abysshop.dto.account.AccountSignUpRequest;
import com.joo.abysshop.dto.account.AccountWithdrawRequest;
import com.joo.abysshop.dto.account.ChangeNicknameRequest;
import com.joo.abysshop.dto.account.ChangePasswordRequest;
import com.joo.abysshop.dto.product.ProductListResponse;
import com.joo.abysshop.enums.JspView;
import com.joo.abysshop.enums.ResultStatus;
import com.joo.abysshop.service.account.AccountService;
import com.joo.abysshop.service.product.ProductService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AccountController {
    //TODO: 모든 redirect return 다시 정의하기

    private final AccountService accountService;
    private final ProductService productService;

    @GetMapping("/account/sign-in")
    public String getSignInPage() {
        return "account/signIn";
    }

    @PostMapping("/account/sign-in")
    public String signIn(@ModelAttribute AccountSignInRequest accountSignInRequest,
        HttpSession session, Model model) {
        ResultStatus signInResult = accountService.signIn(accountSignInRequest, model);

        if (signInResult == ResultStatus.SUCCESS) {
            List<ProductListResponse> productList = productService.findAllProducts();
            model.addAttribute("productList", productList);
            session.setAttribute("isLoggedIn", true);

            return JspView.HOME.getView();
        } else {
            return "redirect:account/signIn";
        }
    }

    @GetMapping("/account/sign-up")
    public String getSignUpPage() {
        return "account/signUp";
    }

    @PostMapping("/account/sign-up")
    public String signUp(@ModelAttribute AccountSignUpRequest accountSignUpRequest) {
        ResultStatus signUpResult = accountService.signUp(accountSignUpRequest);

        if (signUpResult == ResultStatus.SUCCESS) {
            return "account/signIn";
        } else {
            //TODO: 프론트에 응답 보내고 스크립트를 사용해서 에러 메세지 출력하기
            return "redirect:/account/sign-up";
        }
    }

    @PostMapping("/account/change/nickname")
    public String changeNickname(@ModelAttribute ChangeNicknameRequest changeNicknameRequest) {
        ResultStatus changeNicknameResult = accountService.changeNickname(changeNicknameRequest);

        if (changeNicknameResult == ResultStatus.SUCCESS) {
            return "redirect:user/userMyPage?menu=user-info";
        } else {
            //TODO: 프론트에 응답 보내고 스크립트를 사용해서 에러 메세지 출력하기
            return "redirect:user/userMyPage?menu=user-info";
        }
    }

    @PostMapping("/account/change/password")
    public String changePassword(@ModelAttribute ChangePasswordRequest changePasswordRequest) {
        ResultStatus changePasswordResult = accountService.changePassword(changePasswordRequest);

        if (changePasswordResult == ResultStatus.SUCCESS) {
            return "redirect:user/userMyPage?menu=user-info";
        } else {
            //TODO: 프론트에 응답 보내고 스크립트를 사용해서 에러 메세지 출력하기
            return "redirect:user/userMyPage?menu=user-info";
        }
    }

    @PostMapping("/account/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();

        List<ProductListResponse> productList = productService.findAllProducts();
        model.addAttribute("productList", productList);

        return JspView.HOME.getView();
    }

    @PostMapping("/account/withdraw")
    public String withdraw(@ModelAttribute AccountWithdrawRequest accountWithdrawRequest,
        HttpSession session, Model model) {
        ResultStatus withdrawResult = accountService.withdraw(accountWithdrawRequest);

        if (withdrawResult == ResultStatus.SUCCESS) {
            session.invalidate();
            List<ProductListResponse> productList = productService.findAllProducts();
            model.addAttribute("productList", productList);

            return JspView.HOME.getView();
        } else {
            //TODO: 프론트에 응답 보내고 스크립트를 사용해서 에러 메세지 출력하기
            return "redirect:user/userMyPage?menu=user-info";
        }
    }
}
