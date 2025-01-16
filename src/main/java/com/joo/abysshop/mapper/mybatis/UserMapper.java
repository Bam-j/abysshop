package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.entity.user.UserEntity;
import com.joo.abysshop.enums.UserType;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserType getUserType(Long userId);

    Optional<UserEntity> findByUserId(Long userId);
}
