package com.joo.abysshop.service.admin;

import com.joo.abysshop.enums.UserType;
import com.joo.abysshop.mapper.mybatis.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminMyPageService {

    private final AdminMapper adminMapper;

    public String findViewByUserType(final Long userId) {
        UserType userType = adminMapper.getUserType(userId);

        if (userType.equals(UserType.ADMIN)) {
            return "admin/adminMyPage";
        } else {
            return "/";
        }
    }
}