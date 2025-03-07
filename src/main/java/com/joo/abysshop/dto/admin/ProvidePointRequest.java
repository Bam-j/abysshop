package com.joo.abysshop.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProvidePointRequest {

    private Long userId;
    private Long point;
}
