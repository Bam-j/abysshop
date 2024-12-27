package com.joo.abysshop.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int productId;
    private String productname;
    private int price;
    private String description;
    private byte[] image;
    private String type;
}
