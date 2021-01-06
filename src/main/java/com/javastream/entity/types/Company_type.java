package com.javastream.entity.types;


public enum Company_type {

    CLIENT("CLIENT"), SUPPLIER("SUPPLIER"), PARTNER("PARTNER"), OTHER("OTHER");


    private String code;

    Company_type(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
