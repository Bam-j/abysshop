package com.joo.abysshop.service;

import com.joo.abysshop.mapper.AdminMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private AdminMapper adminMapper;

    public void changeOrderState(Long orderId, String newState) {
        Map<String, Object> changeStateMap = new HashMap<>();
        changeStateMap.put("orderId", orderId);
        changeStateMap.put("newState", newState);

        adminMapper.changeOrderState(changeStateMap);
    }
}