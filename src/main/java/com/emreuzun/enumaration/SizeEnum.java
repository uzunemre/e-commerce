package com.emreuzun.enumaration;

public enum SizeEnum {

    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private String message;

    SizeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
