package com.javastream.entity.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Phone.
 *
 * @author javastream
 */
@Data
@Builder
@ToString
public class Phone {
    @SerializedName("ID")
    private String id;

    @SerializedName("TYPE_ID")
    private String typeId;

    @SerializedName("VALUE")
    private String value;

    @SerializedName("VALUE_TYPE")
    private String valueType;
}
