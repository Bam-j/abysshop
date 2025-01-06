package com.joo.abysshop.enums;

public enum ProductType {
    GOODS,
    POINT;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
