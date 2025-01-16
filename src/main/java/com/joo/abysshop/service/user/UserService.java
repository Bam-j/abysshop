package com.joo.abysshop.service.user;

import com.joo.abysshop.enums.UserType;
import com.joo.abysshop.mapper.mybatis.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserMapper userMapper;

    public UserType getUserType(final Long userId) {
        return userMapper.getUserType(userId);
    }
}
