package com.joo.abysshop.dto.user;

import com.joo.abysshop.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserInfoResponse {

    private Integer userId;
    private String username;
    private String nickname;
    private UserType userType;
    private Integer points;
}
