package com.joo.abysshop.service.admin;

import com.joo.abysshop.dto.admin.ChangePointRechargeStateRequest;
import com.joo.abysshop.dto.point.PointRechargeListResponse;
import com.joo.abysshop.entity.point.PointRechargeEntity;
import com.joo.abysshop.entity.user.UserEntity;
import com.joo.abysshop.mapper.dto.ToPointDTOMapper;
import com.joo.abysshop.mapper.mybatis.AdminMapper;
import com.joo.abysshop.mapper.mybatis.PointMapper;
import com.joo.abysshop.mapper.mybatis.UserMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminPointManagementService {

    private final PointMapper pointMapper;
    private final UserMapper userMapper;
    private final AdminMapper adminMapper;
    private final ToPointDTOMapper toPointDTOMapper;

    public List<PointRechargeListResponse> getAllPointRecharge() {
        List<PointRechargeEntity> pointRechargeEntityList = pointMapper.findAllPointRecharge();
        List<PointRechargeListResponse> pointRechargeList = new ArrayList<>();

        for (PointRechargeEntity pointRechargeEntity : pointRechargeEntityList) {
            pointRechargeList.add(
                toPointDTOMapper.toPointRechargeListResponse(pointRechargeEntity));
        }

        return pointRechargeList;
    }

    public void providePoint(Long userId, Long point) {
        Optional<UserEntity> optionalUserEntity = userMapper.findByUserId(userId);
        UserEntity userEntity;

        if (optionalUserEntity.isPresent()) {
            userEntity = optionalUserEntity.get();
        } else {
            return;
        }

        adminMapper.providePoint(userEntity.getUserId(), point);
    }

    public void changePointRechargeState(
        ChangePointRechargeStateRequest changePointRechargeStateRequest) {
        Map<String, Object> changeStateMap = new HashMap<>();
        changeStateMap.put("rechargeId", changePointRechargeStateRequest.getRechargeId());
        changeStateMap.put("newState", changePointRechargeStateRequest.getNewState());

        adminMapper.changePointRechargeState(changeStateMap);
    }
}
