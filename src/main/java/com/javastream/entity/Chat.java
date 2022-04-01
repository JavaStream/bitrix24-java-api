package com.javastream.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

/**
 * Chat.
 *
 * @author javastream
 */
@Data
@ToString
public class Chat {
    @SerializedName("ID")
    private String id;

    @SerializedName("TITLE")
    private String title;

    @SerializedName("DESCRIPTION")
    private String description;

    @SerializedName("COLOR")
    private String color;

    @SerializedName("MESSAGE")
    private String message;
}
