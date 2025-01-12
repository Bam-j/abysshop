package com.joo.abysshop.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
@AllArgsConstructor
public class ProductListResponse {

    private Long productId;
    private String productName;
    private Long price;
    private MultipartFile image;
}
