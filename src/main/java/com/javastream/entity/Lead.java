package com.javastream.entity;

import com.google.gson.annotations.SerializedName;
import com.javastream.entity.model.Email;
import com.javastream.entity.model.Messenger;
import com.javastream.entity.model.Phone;
import com.javastream.entity.model.Website;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * Lead.
 *
 * @author javastream
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class Lead extends Entity{

    @SerializedName("TITLE")
    private String title;

    @SerializedName("NAME")
    public String name;

    @SerializedName("LAST_NAME")
    private String lastName;

    @SerializedName("SECOND_NAME")
    private String secondName;

    @SerializedName("CONTACT_ID")
    private String contactId;

    @SerializedName("STATUS_ID")
    private String statusId;

    @SerializedName("CURRENCY_ID")
    private String currencyId;

    @SerializedName("ADDRESS_PROVINCE")
    private String addressProvince;

    @SerializedName("ADDRESS_COUNTRY_CODE")
    private String addressCountryCode;

    @SerializedName("ADDRESS_COUNTRY")
    private String addressCountry;

    @SerializedName("ADDRESS_REGION")
    private String addressRegion;

    @SerializedName("ADDRESS_CITY")
    private String addressCity;

    @SerializedName("ADDRESS")
    private String address;

    @SerializedName("POST")
    private String post;

    @SerializedName("OPPORTUNITY")
    private String opportunity;

    @SerializedName("ASSIGNED_BY_ID")
    private String assignedById;

    @SerializedName("UTM_SOURCE")
    private String utmSource;

    @SerializedName("COMMENTS")
    private String comments;

    @SerializedName("UTM_MEDIUM")
    private String utmMedium;

    @SerializedName("STATUS_SEMANTIC_ID")
    private String statusSemanticId;

    @SerializedName("HONORIFIC")
    private String honorific;

    @SerializedName("UTM_CONTENT")
    private String utmContent;

    @SerializedName("IS_RETURN_CUSTOMER")
    private String isReturnCustomer;

    @SerializedName("COMPANY_ID")
    private String companyId;

    @SerializedName("SOURCE_ID")
    private String sourceId;

    @SerializedName("ORIGIN_ID")
    private String originId;

    @SerializedName("COMPANY_TITLE")
    private String companyTitle;

    @SerializedName("ORIGINATOR_ID")
    private String originatorId;

    @SerializedName("STATUS_DESCRIPTION")
    private String statusDescription;

    @SerializedName("HAS_EMAIL")
    private String hasEmail;

    @SerializedName("UTM_TERM")
    private String utmTerm;

    @SerializedName("HAS_IMOL")
    private String hasImol;

    @SerializedName("UTM_CAMPAIGN")
    private String utmCampaign;

    @SerializedName("CREATED_BY_ID")
    private String createdById;

    @SerializedName("HAS_PHONE")
    private String hasPhone;

    @SerializedName("OPENED")
    private String opened;

    @SerializedName("EMAIL")
    private List<Email> emails;

    @SerializedName("PHONE")
    private List<Phone> phones;

    @SerializedName("IM")
    private List<Messenger> messengers;

    @SerializedName("WEB")
    private List<Website> websites;
}
