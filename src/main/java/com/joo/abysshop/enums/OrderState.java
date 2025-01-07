package com.joo.abysshop.enums;

public enum OrderState {
    PENDING_PAYMENT,
    SHIPPING,
    COMPLETED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
