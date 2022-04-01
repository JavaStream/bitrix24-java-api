package com.javastream.entity.types;

/**
 * EmailType.
 *
 * @author javastream
 */
public enum EmailType {

    WORK("WORK"), PRIVATE("PRIVATE"), MAILING("MAILING"), OTHER("OTHER");

    private String code;

    EmailType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}