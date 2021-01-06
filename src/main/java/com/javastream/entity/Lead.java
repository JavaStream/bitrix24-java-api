package com.javastream.entity;

import com.javastream.entity.model.Email;
import com.javastream.entity.model.Messenger;
import com.javastream.entity.model.Phone;
import com.javastream.entity.model.Website;
import com.javastream.entity.types.CurrencyID_type;
import com.javastream.entity.types.SourceID_type;
import com.javastream.entity.types.StatusID_type;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/*  Created by JavaStream   */

@Data
@ToString
public class Lead {
    private Integer ID;
    private String TITLE;
    private String NAME;
    private String LAST_NAME;
    private String SECOND_NAME;
    private String CONTACT_ID;
    private String STATUS_ID;
    private String CURRENCY_ID;
    private String ADDRESS_PROVINCE;
    private String ADDRESS_COUNTRY_CODE;
    private String ADDRESS_COUNTRY;
    private String ADDRESS_REGION;
    private String ADDRESS_CITY;
    private String ADDRESS;
    private String POST;
    private String OPPORTUNITY;
    private String ASSIGNED_BY_ID;
    private String UTM_SOURCE;
    private String COMMENTS;
    //private Date BIRTHDATE;
    private String UTM_MEDIUM;
    private String STATUS_SEMANTIC_ID;
    private String HONORIFIC;
    private String UTM_CONTENT;
    private String IS_RETURN_CUSTOMER;
    private String COMPANY_ID;
    //private Date DATE_CREATE;
    //private Date DATE_MODIFY;/
    //private Date DATE_CLOSED;
    private String SOURCE_ID;
    private String ORIGIN_ID;
    private String COMPANY_TITLE;
    private String ORIGINATOR_ID;
    private String STATUS_DESCRIPTION;
    private String HAS_EMAIL;
    private String UTM_TERM;
    private String HAS_IMOL;
    private String UTM_CAMPAIGN;
    private String CREATED_BY_ID;
    private String HAS_PHONE;
    private String OPENED;
    private List<Email> EMAIL;
    private List<Phone> PHONE;
    private List<Messenger> IM;
    private List<Website> WEB;

    public void add_title(String title) {
        this.TITLE = title;
    }

    public void add_name(String name) {
        this.NAME = name;
    }

    public void add_lastName(String lastName) {
        this.LAST_NAME = lastName;
    }

    public void add_secondName(String secondName) {
        this.SECOND_NAME = secondName;
    }

    public void add_statusId(String status) {
        this.STATUS_ID = status;
    }

    public void add_statusId(StatusID_type statusID_type) {
        this.STATUS_ID = statusID_type.getCode();
    }

    public void add_currency(String currency) {
        this.CURRENCY_ID = currency;
    }

    public void add_currency(CurrencyID_type currencyID_type) {
        this.CURRENCY_ID = currencyID_type.getCode();
    }

    public void add_opportunity(String opportunity) {
        this.OPPORTUNITY = opportunity;
    }

    public void add_amount(String amount) {
        this.OPPORTUNITY = amount;
    }

    public void add_post(String post) {
        this.POST = post;
    }

    public void add_comments(String comments) {
        this.COMMENTS = comments;
    }

    public void add_company(Integer companyId) {
        this.COMPANY_ID = companyId.toString();
    }

    public void add_companyTitle(String companyTitle) {
        this.COMPANY_TITLE = companyTitle;
    }

    public void add_sourceId(String sourceId) {
        this.SOURCE_ID = sourceId;
    }

    public void add_sourceId(SourceID_type sourceID_type) {
        this.SOURCE_ID = sourceID_type.getCode();
    }
}
