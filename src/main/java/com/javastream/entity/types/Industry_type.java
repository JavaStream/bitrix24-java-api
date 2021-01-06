package com.javastream.entity.types;


public enum Industry_type {

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

    Industry_type(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
