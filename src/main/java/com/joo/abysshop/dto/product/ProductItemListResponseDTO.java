package com.joo.abysshop.dto.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
//ProductItemListResponseDTO와 동일한 일을 하므로 명확한 이름의 통일된 ProductListResponse를 사용한다.
@Deprecated(since = "1.0")
public class ProductItemListResponseDTO {

    private Long productId;
    private String productName;
    private Long price;
    private MultipartFile image;
}
