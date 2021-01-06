package com.javastream.entity.types;


public enum Phone_type {

    WORK("WORK"), MOBILE("MOBILE"), FAX("FAX"), HOME("HOME"), PAGER("PAGER"), MAILING("MAILING"), OTHER("OTHER");

    private String code;

    Phone_type(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
