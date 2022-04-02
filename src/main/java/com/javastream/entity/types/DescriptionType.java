package com.javastream.entity.types;

/**
 * DescriptionType.
 *
 * @author javastream
 */
public enum DescriptionType {
    TEXT("text"),
    HTML("html");

    private String code;

    DescriptionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}