package com.javastream.entity;

import com.google.gson.annotations.SerializedName;
import com.javastream.entity.model.Email;
import com.javastream.entity.model.Messenger;
import com.javastream.entity.model.Phone;
import com.javastream.entity.model.Website;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class Contact extends Entity{

    public Contact(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @SerializedName("NAME")
    private String name;

    @SerializedName("LAST_NAME")
    private String lastName;

    @SerializedName("SECOND_NAME")
    private String secondName;

    @SerializedName("ADDRESS_PROVINCE")
    private String addressProvince;

    @SerializedName("ADDRESS_COUNTRY_CODE")
    private String addressCountryCode;

    @SerializedName("ADDRESS_REGION")
    private String addressRegion;

    @SerializedName("ADDRESS_COUNTRY")
    private String addressCountry;

    @SerializedName("ADDRESS_CITY")
    private String addressCity;

    @SerializedName("ADDRESS")
    private String address;

    @SerializedName("POST")
    private String post;

    @SerializedName("ORIGIN_VERSION")
    private String originVersion;

    @SerializedName("ASSIGNED_BY_ID")
    private String assignedById;

    @SerializedName("EXPORT")
    private String export;

    @SerializedName("UTM_SOURCE")
    private String utmSource;

    @SerializedName("COMMENTS")
    private String comments;

    @SerializedName("FACE_ID")
    private String faceId;

    @SerializedName("LEAD_ID")
    private String leadId;

    @SerializedName("UTM_MEDIUM")
    private String utmMedium;

    @SerializedName("HONORIFIC")
    private String honorific;

    @SerializedName("UTM_CONTENT")
    private String utmContent;

    @SerializedName("COMPANY_ID")
    private String companyId;

    @SerializedName("DATE_CREATE")
    private Date dateCreate;

    @SerializedName("DATE_MODIFY")
    private Date dateModify;

    @SerializedName("SOURCE_ID")
    private String sourceId;

    @SerializedName("ORIGIN_ID")
    private String originId;

    @SerializedName("ORIGINATOR_ID")
    private String originatorId;

    @SerializedName("HAS_EMAIL")
    private String hasEmail;

    @SerializedName("UTM_TERM")
    private String utmTerm;

    @SerializedName("HAS_IMOL")
    private String hasImol;

    @SerializedName("HAS_PHONE")
    private String hasPhone;

    @SerializedName("UTM_CAMPAIGN")
    private String utmCampaign;

    @SerializedName("TYPE_ID")
    private String typeId;

    @SerializedName("EMAIL")
    private List<Email> emails;

    @SerializedName("PHONE")
    private List<Phone> phones;

    @SerializedName("IM")
    private List<Messenger> messengers;

    @SerializedName("WEB")
    private List<Website> websites;
}