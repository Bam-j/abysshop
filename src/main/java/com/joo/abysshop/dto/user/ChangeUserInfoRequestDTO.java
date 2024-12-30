package com.joo.abysshop.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangeUserInfoRequestDTO {

    private Integer userId;
    private String nickname;
    private String password;
}
