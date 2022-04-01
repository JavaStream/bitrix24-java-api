package com.javastream.entity.types;

/**
 * CompanyType.
 *
 * @author javastream
 */
public enum CompanyType {
    CLIENT("CLIENT"),
    SUPPLIER("SUPPLIER"),
    PARTNER("PARTNER"),
    OTHER("OTHER");

    private String code;

    CompanyType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
