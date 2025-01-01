package com.joo.abysshop.dto.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
public class PointItemListResponseDTO {

    private Integer productId;
    private String productName;
    private Integer price;
    private MultipartFile image;
}