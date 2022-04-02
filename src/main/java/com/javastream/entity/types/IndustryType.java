package com.javastream.entity.types;

/**
 * IndustryType.
 *
 * @author javastream
 */
public enum IndustryType {
    IT("IT"),
    TELECOM("TELECOM"),
    MANUFACTURING("MANUFACTURING"),
    BANKING("BANKING"),
    CONSULTING("CONSULTING"),
    FINANCE("FINANCE"),
    GOVERNMENT("GOVERNMENT"),
    DELIVERY("DELIVERY"),
    ENTERTAINMENT("ENTERTAINMENT"),
    NOTPROFIT("NOTPROFIT"),
    OTHER("OTHER");

    private String code;

    IndustryType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}