package com.joo.abysshop.entity.user;

import com.joo.abysshop.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserEntity {

    private Long userId;
    private String username;
    private String nickname;
    private String password;
    private UserType userType;
    private Long points;
}
