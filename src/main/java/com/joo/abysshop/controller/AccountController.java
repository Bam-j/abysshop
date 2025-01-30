package com.joo.abysshop.controller;

import com.joo.abysshop.dto.account.AccountSignInRequest;
import com.joo.abysshop.dto.account.AccountSignUpRequest;
import com.joo.abysshop.dto.account.AccountWithdrawRequest;
import com.joo.abysshop.dto.account.ChangeNicknameRequest;
import com.joo.abysshop.dto.account.ChangePasswordRequest;
import com.joo.abysshop.dto.product.ProductListResponse;
import com.joo.abysshop.dto.user.UserInfoResponse;
import com.joo.abysshop.enums.JspView;
import com.joo.abysshop.enums.ResultStatus;
import com.joo.abysshop.service.account.AccountService;
import com.joo.abysshop.service.product.ProductService;
import com.joo.abysshop.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class AccountController {
    //TODO: 모든 redirect return 다시 정의하기
    //redirect는 GET 요청을 보낸다. 따라서 return이 view의 이름이 아닌, get 요청 url이어야 한다.
    //할 일 메모 1. 프론트 요청 alert는 redirectAttributes.addFlashAttribute를 사용하도록 교체 + todos 삭제
    //2. 파라미터 포함된 redirect를 RedirectView로 교체

    private final AccountService accountService;
    private final ProductService productService;
    private final UserService userService;

    @GetMapping("/account/sign-in")
    public String getSignInPage() {
        return "account/signIn";
    }

    @PostMapping("/account/sign-in")
    public String signIn(@ModelAttribute AccountSignInRequest accountSignInRequest,
        HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        ResultStatus signInResult = accountService.signIn(accountSignInRequest);

        if (signInResult == ResultStatus.SUCCESS) {
            List<ProductListResponse> productList = productService.findAllProducts();
            model.addAttribute("productList", productList);

            UserInfoResponse userInfo = userService.getUserInfo(accountSignInRequest.getUsername());
            session.setAttribute("user", userInfo);
            session.setAttribute("isLoggedIn", true);

            return JspView.HOME.getView();
        } else if (signInResult == ResultStatus.INVALID_USERNAME) {
            redirectAttributes.addFlashAttribute("failureMessage", "존재하지 않는 계정입니다.");
            return "redirect:/account/sign-in";
        } else if (signInResult == ResultStatus.INVALID_PASSWORD) {
            redirectAttributes.addFlashAttribute("failureMessage", "패스워드가 일치하지 않습니다.");
            return "redirect:/account/sign-in";
        } else {
            return "redirect:/account/sign-in";
        }
    }

    @GetMapping("/account/sign-up")
    public String getSignUpPage() {
        return "account/signUp";
    }

    @PostMapping("/account/sign-up")
    public String signUp(@ModelAttribute AccountSignUpRequest accountSignUpRequest,
        RedirectAttributes redirectAttributes) {
        ResultStatus signUpResult = accountService.signUp(accountSignUpRequest);

        if (signUpResult == ResultStatus.SUCCESS) {
            return "account/signIn";
        } else if (signUpResult == ResultStatus.DUPLICATE_USERNAME) {
            redirectAttributes.addFlashAttribute("failureMessage", "이미 존재하는 계정입니다.");
            return "redirect:/account/sign-up";
        } else if (signUpResult == ResultStatus.DUPLICATE_NICKNAME) {
            redirectAttributes.addFlashAttribute("failureMessage", "이미 존재하는 닉네임입니다.");
            return "redirect:/account/sign-up";
        } else {
            return "redirect:/account/sign-up";
        }
    }

    @PostMapping("/account/change/nickname")
    public RedirectView changeNickname(@ModelAttribute ChangeNicknameRequest changeNicknameRequest) {
        ResultStatus changeNicknameResult = accountService.changeNickname(changeNicknameRequest);

        Long userId = changeNicknameRequest.getUserId();
        String url = "/user/my-page/" + userId + "?menu=user-info";

        if (changeNicknameResult == ResultStatus.SUCCESS) {
            return new RedirectView(url);
        } else {
            //TODO: flashAttribute 사용되는 모든 부분에 alert를 띄우는 js 스크립트 삽입하기
            return new RedirectView(url);
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
