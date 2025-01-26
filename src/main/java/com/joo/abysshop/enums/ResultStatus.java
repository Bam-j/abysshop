package com.joo.abysshop.enums;

public enum ResultStatus {
    //일반 요청에 대한 성공 & 실패
    SUCCESS,
    FAILURE,

    //Sign In 과정에서 실패 상태
    WRONG_USERNAME,
    WRONG_PASSWORD,

    //Sign Up 과정에서 실패 상태
    USERNAME_FOUND,
    NICKNAME_FOUND;
}
