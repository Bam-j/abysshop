package com.joo.abysshop.dto.user;

import com.joo.abysshop.enums.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserInfoResponse {

    private Integer userId;
    private String username;
    private String nickname;
    private UserType userType;
    private Integer points;
}
