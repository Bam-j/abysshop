package com.joo.abysshop.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductType {
    GOODS("goods"),
    POINT("point");

    private final String productType;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
