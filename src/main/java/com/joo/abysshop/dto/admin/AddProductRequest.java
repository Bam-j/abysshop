package com.joo.abysshop.dto.admin;

import com.joo.abysshop.enums.ProductType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
public class AddProductRequest {

    private String productName;
    private Integer price;
    private String description;
    private MultipartFile image;
    private ProductType productType;
}
