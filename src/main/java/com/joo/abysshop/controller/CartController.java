package com.joo.abysshop.controller;

import com.joo.abysshop.constants.Messages;
import com.joo.abysshop.constants.ModelAttributeNames;
import com.joo.abysshop.constants.RedirectMappings;
import com.joo.abysshop.constants.ViewNames;
import com.joo.abysshop.dto.cart.AddItemRequest;
import com.joo.abysshop.dto.cart.CartItemResponse;
import com.joo.abysshop.dto.cart.CartResponse;
import com.joo.abysshop.dto.cart.RemoveItemRequest;
import com.joo.abysshop.service.cart.CartService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/user/cart/{userId}")
    public String getUserCartPage(@PathVariable("userId") Long userId, Model model) {
        CartResponse cart = cartService.getCart(userId);
        model.addAttribute(ModelAttributeNames.CART, cart);

        Long cartId = cart.getCartId();
        List<CartItemResponse> cartItemList = cartService.getUserCartItems(cartId);
        model.addAttribute(ModelAttributeNames.CART_ITEM_LIST, cartItemList);

        return ViewNames.SHOPPING_CART_PAGE;
    }

    @PostMapping("/cart/item/add")
    public String addItemToCart(@ModelAttribute AddItemRequest addItemRequest, HttpSession session,
        RedirectAttributes redirectAttributes) {
        if (session.getAttribute("user") == null) {
            redirectAttributes.addFlashAttribute(Messages.FAILURE_MESSAGE, "로그인을 해주세요.");
            return RedirectMappings.REDIRECT_INDEX;
        }

        if (cartService.isCartItemExists(addItemRequest)) {
            //카트에 상품이 존재하면 레코드를 새로 추가하지 않고, 존재하는 레코드의 quantity를 1 증가
            cartService.increaseQuantity(addItemRequest);
        } else {
            //카트에 상품이 존재하지 않으면 새로 레코드 추가
            cartService.addItem(addItemRequest);
        }
        return RedirectMappings.REDIRECT_INDEX;
    }

    @PostMapping("/cart/item/remove")
    public RedirectView removeItemFromCart(@ModelAttribute RemoveItemRequest removeItemRequest,
        Model model) {
        cartService.removeItem(removeItemRequest);

        Long userId = removeItemRequest.getUserId();
        CartResponse cart = cartService.getCart(userId);
        model.addAttribute(ModelAttributeNames.CART, cart);

        Long cartId = cart.getCartId();
        List<CartItemResponse> cartItemList = cartService.getUserCartItems(cartId);
        model.addAttribute(ModelAttributeNames.CART_ITEM_LIST, cartItemList);

        return new RedirectView("/user/cart/" + userId);
    }

    /*
        페이지 디자인 작업용으로 사용하는 임시 GET 요청.
        실제 동작은 /order/cart/{id}로 사용할 것. (id는 회원의 id)
     */
    @GetMapping("/cart")
    public String cart() {
        return "order/shoppingCart";
    }
}
