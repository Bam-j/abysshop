package com.joo.abysshop.mapper.mybatis;

import com.joo.abysshop.entity.cart.CartEntity;
import com.joo.abysshop.entity.cart.CartItemEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

    CartEntity getCart(Long userId);

    List<CartItemEntity> getCartItems(Long cartId);

    void removeItem(Map<String, Object> removeItemMap);

    Long getQuantity(Long cartId);

    Long getTotalPoints(Long cartId);
}
