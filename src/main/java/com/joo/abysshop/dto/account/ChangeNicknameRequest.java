package com.joo.abysshop.dto.account;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChangeNicknameRequest {

    private Long userId;
    private String newNickname;
}
