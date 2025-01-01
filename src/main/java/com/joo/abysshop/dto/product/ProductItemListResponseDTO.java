package com.joo.abysshop.dto.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
public class ProductItemListResponseDTO {

    private Long productId;
    private String productName;
    private Long price;
    private MultipartFile image;
}
