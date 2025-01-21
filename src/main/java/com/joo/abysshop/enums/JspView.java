package com.joo.abysshop.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JspView {
    HOME("index"),
    REDIRECT("redirect:/");

    private final String view;
}
