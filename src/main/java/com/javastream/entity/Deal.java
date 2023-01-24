package com.javastream.entity;

import com.google.gson.annotations.SerializedName;
import com.javastream.entity.model.Email;
import com.javastream.entity.model.Messenger;
import com.javastream.entity.model.Phone;
import com.javastream.entity.model.Website;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * Contact.
 *
 * UPD: name and lastName are mandatory fields for creation a new Contract
 *
 * @author javastream
 */
@Data
@ToString
public class Deal {

    public Deal(String title) {
        this.title = title;
    }

    @SerializedName("ID")
    private Integer id;

    @SerializedName("TITLE")
    private String title;

    @SerializedName("TYPE_ID")
    private String titleId;

    @SerializedName("STAGE_ID")
    private String stageId;

    @SerializedName("PROBABILITY")
    private String probability;

    @SerializedName("CURRENCY_ID")
    private String currencyId;
}