package com.joo.abysshop.enums;

public enum OrderState {
    SHIPPING,
    COMPLETED,
    REFUNDED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
