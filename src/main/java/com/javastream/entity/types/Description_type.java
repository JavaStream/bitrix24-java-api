package com.javastream.entity.types;


public enum Description_type {

    TEXT("text"), HTML("html");


    private String code;

    Description_type(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
