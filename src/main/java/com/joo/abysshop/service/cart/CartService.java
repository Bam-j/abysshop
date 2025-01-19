package com.joo.abysshop.service.cart;

import com.joo.abysshop.dto.cart.UserCartItemResponse;
import com.joo.abysshop.dto.cart.UserCartResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    public UserCartResponse getUserCart(Long userId) {
        return null;
    }

    public List<UserCartItemResponse> getUserCartItems() {
        return null;
    }
}
