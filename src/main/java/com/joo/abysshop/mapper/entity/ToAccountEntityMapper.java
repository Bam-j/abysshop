package com.joo.abysshop.mapper.entity;

import com.joo.abysshop.dto.account.AccountSignUpRequest;
import com.joo.abysshop.entity.account.SignUpEntity;
import org.springframework.stereotype.Component;

@Component
public interface ToAccountEntityMapper {

    SignUpEntity toSignUpEntity(AccountSignUpRequest accountSignUpRequest);
}
