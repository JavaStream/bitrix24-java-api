package com.javastream.entity.types;

/**
 * CurrencyIdType.
 *
 * @author javastream
 */
public enum CurrencyIdType {
    RUB("RUB"),
    USD("USD"),
    EUR("EUR"),
    UAH("UAH"),
    BYN("BYN");

    private String code;

    CurrencyIdType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
