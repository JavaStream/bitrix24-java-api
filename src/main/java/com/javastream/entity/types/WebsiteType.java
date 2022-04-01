package com.javastream.entity.types;

/**
 * WebsiteType.
 *
 * @author javastream
 */
public enum WebsiteType {
    WORK("WORK"),
    HOME("HOME"),
    FACEBOOK("FACEBOOK"),
    VK("VK"),
    LIVEJOURNAL("LIVEJOURNAL"),
    TWITTER("TWITTER"),
    OTHER("OTHER");

    private String code;

    WebsiteType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}