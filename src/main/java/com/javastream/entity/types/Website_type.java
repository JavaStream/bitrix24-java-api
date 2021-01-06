package com.javastream.entity.types;


public enum Website_type {

    WORK("WORK"),
    HOME("HOME"),
    FACEBOOK("FACEBOOK"),
    VK("VK"),
    LIVEJOURNAL("LIVEJOURNAL"),
    TWITTER("TWITTER"),
    OTHER("OTHER");

    private String code;

    Website_type(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
