package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.dto.cart.UserCartItemResponse;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

    List<UserCartItemResponse> findAllItems(Long userId);

    Long getCartId(Long userId);
}
