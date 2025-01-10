package com.joo.abysshop.mapper.entity;

import com.joo.abysshop.dto.account.AccountSignUpRequest;
import com.joo.abysshop.entity.account.SignUpEntity;
import org.springframework.stereotype.Component;

@Component
public class ToAccountEntityMapperImpl implements ToAccountEntityMapper {

    @Override
    public SignUpEntity toSignUpEntity(AccountSignUpRequest accountSignUpRequest) {
        return SignUpEntity.builder()
            .username(accountSignUpRequest.getUsername())
            .nickname(accountSignUpRequest.getNickname())
            .password(accountSignUpRequest.getPassword())
            .build();
    }
}
