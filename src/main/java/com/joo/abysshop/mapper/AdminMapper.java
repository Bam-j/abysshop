package com.joo.abysshop.mapper;

import com.joo.abysshop.dto.order.OrderHistoryResponse;
import com.joo.abysshop.enums.UserType;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    UserType getUserType(Long id);

    List<OrderHistoryResponse> getOrderHistory();

    void changeOrderState(Map changeStateMap);
}
