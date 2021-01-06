package com.javastream.entity.types;


public enum ChatNotifications_type {

    YES("Y"),
    NOT("N");

    private String code;

    ChatNotifications_type(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}