package com.javastream.entity.types;


public enum Email_type {

    WORK("WORK"), PRIVATE("PRIVATE"), MAILING("MAILING"), OTHER("OTHER");

    private String code;

    Email_type(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
