package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.entity.UserEntity;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    Optional<UserEntity> findByUserId(Long userId);
}
