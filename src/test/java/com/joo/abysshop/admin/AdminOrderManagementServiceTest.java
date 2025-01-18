package com.joo.abysshop.admin;

import com.joo.abysshop.enums.ProductType;
import com.joo.abysshop.service.admin.AdminOrderManagementService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class AdminOrderManagementServiceTest {

    @Autowired
    private AdminOrderManagementService adminOrderManagementService;

}