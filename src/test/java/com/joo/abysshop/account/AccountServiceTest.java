package com.joo.abysshop.account;

import com.joo.abysshop.dto.account.AccountSignInRequest;
import com.joo.abysshop.dto.account.AccountSignUpRequest;
import com.joo.abysshop.entity.user.UserEntity;
import com.joo.abysshop.enums.ResultStatus;
import com.joo.abysshop.service.account.AccountService;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {
    //TODO: 테스트 로직 전수조사

    @Autowired
    private AccountService accountService;

    @Test
    @Transactional
    @DisplayName("회원가입 테스트")
    void signUpTest() {
        //given
        AccountSignUpRequest accountSignUpRequest = AccountSignUpRequest.builder()
            .username("test")
            .nickname("test")
            .password("test")
            .build();

        //when
        ResultStatus signUpResult = accountService.signUp(accountSignUpRequest);

        //then
        assertThat(signUpResult).isEqualTo(ResultStatus.SUCCESS);
    }

    @Test
    @Transactional
    @DisplayName("로그인 테스트")
    void signInTest() {
        //given
        //로그인 테스트 계정(id, username, nick, pw): 1, "user1", "user1", "0000"
        AccountSignInRequest accountSignInRequest = AccountSignInRequest.builder()
            .username("user1")
            .password("0000")
            .build();

        //when
        ResultStatus signInResult = accountService.signIn(accountSignInRequest);

        //then
        assertThat(signInResult).isEqualTo(ResultStatus.SUCCESS);
    }
}