package com.javastream.entity.types;

/**
 * TypeIdContact.
 *
 * @author javastream
 */
public enum TypeIdContact {
    CLIENT("CLIENT"),
    SUPPLIER("SUPPLIER"),
    PARTNER("PARTNER"),
    OTHER("OTHER");

    private String code;

    TypeIdContact(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}