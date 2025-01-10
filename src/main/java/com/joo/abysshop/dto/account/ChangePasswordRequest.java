package com.joo.abysshop.dto.account;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChangePasswordRequest {

    private Long userId;
    private String newPassword;
}
