package com.javastream.entity.types;


public enum Type_id_contact {

    CLIENT("CLIENT"), SUPPLIER("SUPPLIER"), PARTNER("PARTNER"), OTHER("OTHER");
    private String code;

    Type_id_contact(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
