package com.joo.abysshop.entity.account;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class AccountEntity {

    String username;
    String nickname;
    String password;
}
