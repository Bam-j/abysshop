package com.joo.abysshop.dto.account;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountSignUpRequestDTO {

    private String username;
    private String nickname;
    private String password;
}
