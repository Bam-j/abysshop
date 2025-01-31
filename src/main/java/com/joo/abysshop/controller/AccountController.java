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
            redirectAttributes.addFlashAttribute("failureMessage", "처리 오류");
            return "redirect:/account/sign-up";
        }
    }

    @PostMapping("/account/change/nickname")
    public RedirectView changeNickname(@ModelAttribute ChangeNicknameRequest changeNicknameRequest,
        RedirectAttributes redirectAttributes) {
        ResultStatus changeNicknameResult = accountService.changeNickname(changeNicknameRequest);

        Long userId = changeNicknameRequest.getUserId();
        String url = "/user/my-page/" + userId + "?menu=user-info";

        if (changeNicknameResult == ResultStatus.SUCCESS) {
            return new RedirectView(url);
        } else if (changeNicknameResult == ResultStatus.BAD_REQUEST) {
            redirectAttributes.addFlashAttribute("failureMessage", "잘못된 요청입니다.");
            return new RedirectView(url);
        } else if (changeNicknameResult == ResultStatus.SAME_NICKNAME) {
            redirectAttributes.addFlashAttribute("failureMessage", "동일한 닉네임으로의 변경은 불가능합니다.");
            return new RedirectView(url);
        } else if (changeNicknameResult == ResultStatus.DUPLICATE_NICKNAME) {
            redirectAttributes.addFlashAttribute("failureMessage", "이미 사용중인 닉네임입니다.");
            return new RedirectView(url);
        } else {
            redirectAttributes.addFlashAttribute("failureMessage", "처리 오류");
            return new RedirectView(url);
        }
    }

    @PostMapping("/account/change/password")
    public RedirectView changePassword(@ModelAttribute ChangePasswordRequest changePasswordRequest,
        RedirectAttributes redirectAttributes) {
        ResultStatus changePasswordResult = accountService.changePassword(changePasswordRequest);

        Long userId = changePasswordRequest.getUserId();
        String url = "/user/my-page/" + userId + "?menu=user-info";

        if (changePasswordResult == ResultStatus.SUCCESS) {
            return new RedirectView(url);
        } else if (changePasswordResult == ResultStatus.BAD_REQUEST) {
            redirectAttributes.addFlashAttribute("failureMessage", "잘못된 요청입니다.");
            return new RedirectView(url);
        } else if (changePasswordResult == ResultStatus.SAME_PASSWORD) {
            redirectAttributes.addFlashAttribute("failureMessage", "동일한 패스워드로의 변경은 불가능합니다.");
            return new RedirectView(url);
        } else {
            redirectAttributes.addFlashAttribute("failureMessage", "처리 오류");
            return new RedirectView(url);
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
    public RedirectView withdraw(@ModelAttribute AccountWithdrawRequest accountWithdrawRequest,
        HttpSession session, Model model) {
        ResultStatus withdrawResult = accountService.withdraw(accountWithdrawRequest);

        if (withdrawResult == ResultStatus.SUCCESS) {
            session.invalidate();

            List<ProductListResponse> productList = productService.findAllProducts();
            model.addAttribute("productList", productList);

            return new RedirectView("/");
        } else {
            Long userId = accountWithdrawRequest.getUserId();
            String url = "/user/my-page/" + userId + "?menu=user-info";
            return new RedirectView(url);
        }
    }
}
