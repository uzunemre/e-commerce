package com.emreuzun.enumaration;

public enum ColorEnum {

    BLACK("Black"),
    GREEN("Green"),
    MEDIUM("Medium"),
    RED("Red"),
    WHITE("White");

    private String message;

    ColorEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
