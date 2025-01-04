package com.joo.abysshop.dto.order;

import com.joo.abysshop.enums.OrderState;
import com.joo.abysshop.enums.ProductType;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
//주문내역은 ItemOrderResponse, PointOrderResponse로 사용
@Deprecated
public class OrderHistoryResponse {

    private Integer orderId;
    private Integer userId;
    private LocalDateTime orderDate;
    private Integer totalPrice;
    private OrderState orderState;
    private ProductType productType;
}
