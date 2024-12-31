package com.joo.abysshop.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int productId;
    private String productName;
    private int price;
    private String description;
    private byte[] image;
    private String type;
}
