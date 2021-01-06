package com.javastream.entity.types;


public enum SourceID_type {

    CALL("CALL"),
    EMAIL("EMAIL"),
    WEB("WEB"),
    ADVERTISING("ADVERTISING"),
    PARTNER("PARTNER"),
    RECOMMENDATION("RECOMMENDATION"),
    TRADE_SHOW("TRADE_SHOW"),
    WEBFORM("WEBFORM"),
    CALLBACK("CALLBACK"),
    RC_GENERATOR("RC_GENERATOR"),
    STORE("STORE"),
    OTHER("OTHER");

    private String code;

    SourceID_type(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
// ORIGIN_ID