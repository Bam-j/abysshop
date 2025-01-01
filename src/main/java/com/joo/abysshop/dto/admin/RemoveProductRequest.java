package com.joo.abysshop.dto.admin;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RemoveProductRequest {

    private Integer productId;
}
