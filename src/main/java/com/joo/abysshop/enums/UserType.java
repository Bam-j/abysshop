package com.joo.abysshop.enums;

public enum UserType {
    USER,
    ADMIN;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
