package com.javastream.uriParamsCreator;


import java.math.BigDecimal;

public class UriParamsCreator {

    private final static String QUESTION_PATTERN = "?";
    private final static String EQUAL_PATTERN = "=";
    private final static String AMPERSAND_PATTERN = "&";

    public StringBuilder builder = new StringBuilder();

    public UriParamsCreator() {
        this.builder.append(QUESTION_PATTERN);
    }

    public void put(String key, String value) {
        this.builder.append(key);
        this.builder.append(EQUAL_PATTERN);
        this.builder.append(value);
        this.builder.append(AMPERSAND_PATTERN);
    }

    public void put(String key, Integer value) {
        this.builder.append(key);
        this.builder.append(EQUAL_PATTERN);
        this.builder.append(value);
        this.builder.append(AMPERSAND_PATTERN);
    }

    public void put(String key, Double value) {
        this.builder.append(key);
        this.builder.append(EQUAL_PATTERN);
        this.builder.append(value);
        this.builder.append(AMPERSAND_PATTERN);
    }

    public void put(String key, BigDecimal value) {
        this.builder.append(key);
        this.builder.append(EQUAL_PATTERN);
        this.builder.append(value);
        this.builder.append(AMPERSAND_PATTERN);
    }

    public String build() {
        if (builder.toString().contains(AMPERSAND_PATTERN))
            this.builder.deleteCharAt(builder.lastIndexOf(AMPERSAND_PATTERN));
        return builder.toString();
    }

    public StringBuilder getParameters() {
        StringBuilder params = builder;
        params.replace(0, 1, "");
        return params;
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
