package com.javastream.entity.types;


public enum CurrencyID_type {

    RUB("RUB"), USD("USD"), EUR("EUR"), UAH("UAH"), BYN("BYN");

    private String code;

    CurrencyID_type(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
