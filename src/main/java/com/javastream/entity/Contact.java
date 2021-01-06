package com.javastream.entity;

import com.javastream.entity.model.Email;
import com.javastream.entity.model.Messenger;
import com.javastream.entity.model.Phone;
import com.javastream.entity.model.Website;
import com.javastream.entity.types.Type_id_contact;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import java.util.List;

/*  Created by JavaStream   */

@Data
@ToString
public class Contact {
    private Integer ID;
    private String NAME;
    private String LAST_NAME;
    private String SECOND_NAME;
    private String ADDRESS_PROVINCE;
    private String ADDRESS_COUNTRY_CODE;
    private String ADDRESS_REGION;
    private String ADDRESS_COUNTRY;
    private String ADDRESS_CITY;
    private String ADDRESS;
    private String POST;
    private String ORIGIN_VERSION;
    private String ASSIGNED_BY_ID;
    private String EXPORT;
    private String UTM_SOURCE;
    private String COMMENTS;
    //private Date BIRTHDATE;
    private String FACE_ID;
    private String UF_CRM_1577981905016;
    private String LEAD_ID;
    private String UTM_MEDIUM;
    private String HONORIFIC;
    private String UTM_CONTENT;
    private String UF_CRM_1577987768796;
    private String COMPANY_ID;
    private Date DATE_CREATE;
    private Date DATE_MODIFY;
    private String SOURCE_ID;
    private String ORIGIN_ID;
    private String ORIGINATOR_ID;
    private String HAS_EMAIL;
    private String UTM_TERM;
    private String HAS_IMOL;
    private String HAS_PHONE;
    private String UTM_CAMPAIGN;
    private String TYPE_ID;
    private List<Email> EMAIL;
    private List<Phone> PHONE;
    private List<Messenger> IM;
    private List<Website> WEB;

    public void add_name_and_lastName(String name, String lastName) {
        this.NAME=name;
        this.LAST_NAME=lastName;
    }

    public void add_secondName(String secondName) {
        this.SECOND_NAME = secondName;
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

    public void add_type_id(String type_id) {
        this.TYPE_ID = type_id;
    }

    public void add_type_id(Type_id_contact type_idContact) {
        this.TYPE_ID = type_idContact.getCode();
    }
}
