package com.javastream.entity.types;

/**
 * StatusIdType.
 *
 * @author javastream
 */
public enum StatusIdType {
    NEW("NEW"),
    IN_PROCESS("IN_PROCESS"),
    PROCESSED("PROCESSED"),
    JUNK("JUNK");

    private String code;

    StatusIdType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}