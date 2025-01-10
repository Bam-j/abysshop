package com.joo.abysshop.dto.account;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountSignUpResponse {

    private String username;
    private String nickname;
}
