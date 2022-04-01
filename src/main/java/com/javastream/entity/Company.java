package com.javastream.entity;

import com.google.gson.annotations.SerializedName;
import com.javastream.entity.model.Email;
import com.javastream.entity.model.Messenger;
import com.javastream.entity.model.Phone;
import com.javastream.entity.model.Website;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Company.
 *
 * @author javastream
 */
@Data
@ToString
public class Company {
    @SerializedName("ID")
    private Integer id;

    @SerializedName("TITLE")
    private String title;

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

    @SerializedName("ADDRESS_POSTAL_CODE")
    private String addressPostalCode;

    @SerializedName("REG_ADDRESS_POSTAL_CODE")
    private String regAddressPostalCode;

    @SerializedName("REG_ADDRESS_COUNTRY")
    private String regAddressCountry;

    @SerializedName("ADDRESS_LEGAL")
    private String addressLegal;

    @SerializedName("REG_ADDRESS_REGION")
    private String regAddressRegion;

    @SerializedName("REG_ADDRESS_COUNTRY_CODE")
    private String regAddressCountryCode;

    @SerializedName("REG_ADDRESS_PROVINCE")
    private String regAddressProvince;

    @SerializedName("REG_ADDRESS_CITY")
    private String regAddressCity;

    @SerializedName("ADDRESS")
    private String address;

    @SerializedName("ADDRESS_2")
    private String addressAdditional;

    @SerializedName("REG_ADDRESS")
    private String regAddress;

    @SerializedName("REG_ADDRESS_2")
    private String regAddressAdditional;

    @SerializedName("ASSIGNED_BY_ID")
    private String assignedById;

    @SerializedName("UTM_SOURCE")
    private String utmSource;

    @SerializedName("COMMENTS")
    private String comments;

    @SerializedName("UTM_MEDIUM")
    private String utmMedium;

    @SerializedName("UTM_CONTENT")
    private String utmContent;

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

    @SerializedName("UTM_CAMPAIGN")
    private String utmCampaign;

    @SerializedName("MODIFY_BY_ID")
    private String modifyById;

    @SerializedName("CREATED_BY_ID")
    private String createdById;

    @SerializedName("HAS_PHONE")
    private String hasPhone;

    @SerializedName("OPENED")
    private String opened;

    @SerializedName("COMPANY_TYPE")
    private String companyType;

    @SerializedName("INDUSTRY")
    private String industry;

    @SerializedName("EMPLOYEES")
    private String employees;

    @SerializedName("ORIGIN_VERSION")
    private String originVersion;

    @SerializedName("IS_MY_COMPANY")
    private String isMyCompany;

    @SerializedName("LEAD_ID")
    private String leadId;

    @SerializedName("REVENUE")
    private String revenue;

    @SerializedName("BANKING_DETAILS")
    private String bankingDetails;

    @SerializedName("EMAIL")
    private List<Email> emails;

    @SerializedName("PHONE")
    private List<Phone> phones;

    @SerializedName("IM")
    private List<Messenger> messengers;

    @SerializedName("WEB")
    private List<Website> websites;
}