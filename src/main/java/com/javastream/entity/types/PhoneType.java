package com.javastream.entity.types;

/**
 * PhoneType.
 *
 * @author javastream
 */
public enum PhoneType {
    WORK("WORK"),
    MOBILE("MOBILE"),
    FAX("FAX"),
    HOME("HOME"),
    PAGER("PAGER"),
    MAILING("MAILING"),
    OTHER("OTHER");

    private final String code;

    PhoneType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}