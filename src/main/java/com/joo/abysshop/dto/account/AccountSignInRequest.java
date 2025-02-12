package com.joo.abysshop.dto.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AccountSignInRequest {

    private String username;
    private String password;
}
