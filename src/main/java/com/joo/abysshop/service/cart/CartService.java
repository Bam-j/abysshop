package com.joo.abysshop.service.cart;

import com.joo.abysshop.dto.cart.CartItemResponse;
import com.joo.abysshop.dto.cart.CartResponse;
import com.joo.abysshop.dto.cart.RemoveItemRequest;
import com.joo.abysshop.entity.cart.CartEntity;
import com.joo.abysshop.entity.cart.CartItemEntity;
import com.joo.abysshop.mapper.dto.ToCartDTOMapper;
import com.joo.abysshop.mapper.mybatis.CartMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartMapper cartMapper;
    private final ToCartDTOMapper toCartDTOMapper;

    public CartResponse getCart(Long userId) {
        CartEntity cartEntity = cartMapper.getCart(userId);
        CartResponse cartResponse = toCartDTOMapper.toCartResponse(cartEntity);

        return cartResponse;
    }

    public List<CartItemResponse> getUserCartItems(Long cartId) {
        List<CartItemEntity> cartItemEntityList = cartMapper.getCartItems(cartId);
        List<CartItemResponse> cartItemResponseList = new ArrayList<>();

        for (CartItemEntity cartItemEntity : cartItemEntityList) {
            cartItemResponseList.add(toCartDTOMapper.toCartItemResponse(cartItemEntity));
        }

        return cartItemResponseList;
    }

    public void removeItem(RemoveItemRequest removeItemRequest) {
        Long cartId = removeItemRequest.getCartId();
        Long productId = removeItemRequest.getProductId();
        Map<String, Object> removeItemMap = new HashMap<>();

        removeItemMap.put("cartId", cartId);
        removeItemMap.put("productId", productId);
        cartMapper.removeItem(removeItemMap);
    }

    public Long getQuantity(Long cartId) {
        return cartMapper.getQuantity(cartId);
    }

    public Long getTotalPoints(Long cartId) {
        return cartMapper.getTotalPoints(cartId);
    }
}
