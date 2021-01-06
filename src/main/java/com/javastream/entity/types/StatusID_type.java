package com.javastream.entity.types;


public enum StatusID_type {

    NEW("NEW"), IN_PROCESS("IN_PROCESS"), PROCESSED("PROCESSED"), JUNK("JUNK");

    private String code;

    StatusID_type(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
