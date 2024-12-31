package com.joo.abysshop.entity;

import com.joo.abysshop.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {

    private Long userId;
    private String username;
    private String nickname;
    private String password;
    private UserType userType;
    private Long points;
}
