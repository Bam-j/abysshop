package com.joo.abysshop.admin;

import com.joo.abysshop.dto.order.OrderResponse;
import com.joo.abysshop.entity.ProductInOrderEntity;
import com.joo.abysshop.enums.ProductType;
import com.joo.abysshop.mapper.dto.ToOrderDTOMapper;
import com.joo.abysshop.mapper.mybatis.AdminMapper;
import com.joo.abysshop.service.admin.AdminOrderManagementService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class GetOrderResponseTest {

    @Autowired
    private AdminOrderManagementService adminOrderManagementService;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ToOrderDTOMapper<OrderResponse> toOrderDTOMapper;

    @BeforeEach
    void setUp() {
        System.out.println(adminOrderManagementService);
    }

    @Test
    @DisplayName("하드 코딩 취득")
    void getGoodsOrderResponseList() {
        //given
        List<ProductInOrderEntity> entityList = new ArrayList<>();
        List<OrderResponse> orderResponseList = new ArrayList<>();

        //when
        entityList = adminMapper.findAllGoodsOrder();

        for (ProductInOrderEntity productInOrderEntity : entityList) {
            orderResponseList.add(
                toOrderDTOMapper.mapToOrderResponse(productInOrderEntity, ProductType.GOODS));
        }

        //then
        System.out.println(orderResponseList);
        assertThat(orderResponseList).isNotNull();
    }

    /*
    @Test
    @DisplayName("OrderResponse 취득 테스트")
    void getOrderResponse() {
        //given
        List<OrderResponse> resultList = adminOrderManagementService.filterOrders(ProductType.GOODS);

        //when
        System.out.println(resultList);

        //then
        assertThat(resultList).isNotNull();
    }

     */
}