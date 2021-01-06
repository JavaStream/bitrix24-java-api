package com.javastream.entity.types;


public enum Messengers_type {

    FACEBOOK("FACEBOOK"),
    TELEGRAM("TELEGRAM"),
    VK("VK"),
    SKYPE("SKYPE"),
    VIBER("VIBER"),
    INSTAGRAM("INSTAGRAM"),
    BITRIX24("BITRIX24"),
    OPENLINE("OPENLINE"),
    IMOL("IMOL"),
    ICQ("ICQ"),
    MSN("MSN"),
    JABBER("JABBER"),
    OTHER("OTHER");

    private String code;

    Messengers_type(String code){
        this.code = code;
    }

    public String getCode(){ return code;}

}
