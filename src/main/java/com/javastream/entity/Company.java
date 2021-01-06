package com.javastream.entity;

import com.javastream.entity.model.Email;
import com.javastream.entity.model.Messenger;
import com.javastream.entity.model.Phone;
import com.javastream.entity.model.Website;
import com.javastream.entity.types.Company_type;
import com.javastream.entity.types.Employees_type;
import com.javastream.entity.types.Industry_type;
import lombok.Data;
import lombok.ToString;
import java.util.List;

/*  Created by JavaStream   */

@Data
@ToString
public class Company {
    private Integer ID;
    private String TITLE;
    private String ADDRESS_PROVINCE;
    private String ADDRESS_COUNTRY_CODE;
    private String ADDRESS_COUNTRY;
    private String ADDRESS_REGION;
    private String ADDRESS_CITY;
    private String ADDRESS_POSTAL_CODE;
    private String REG_ADDRESS_POSTAL_CODE;
    private String REG_ADDRESS_COUNTRY;
    private String ADDRESS_LEGAL;
    private String REG_ADDRESS_REGION;
    private String REG_ADDRESS_COUNTRY_CODE;
    private String REG_ADDRESS_PROVINCE;
    private String REG_ADDRESS_CITY;
    private String ADDRESS;
    private String ADDRESS_2;
    private String REG_ADDRESS_2;
    private String REG_ADDRESS;
    private String ASSIGNED_BY_ID;
    private String UTM_SOURCE;
    private String COMMENTS;
    private String UTM_MEDIUM;
    private String UTM_CONTENT;
    //private Date DATE_CREATE;
    //private Date DATE_MODIFY;
    private String ORIGIN_ID;
    private String ORIGINATOR_ID;
    private String HAS_EMAIL;
    private String UTM_TERM;
    private String HAS_IMOL;
    private String UTM_CAMPAIGN;
    private String MODIFY_BY_ID;
    private String CREATED_BY_ID;
    private String HAS_PHONE;
    private String OPENED;
    private String COMPANY_TYPE;
    private String INDUSTRY;
    private String EMPLOYEES;
    private String ORIGIN_VERSION;
    private String IS_MY_COMPANY;
    private String LEAD_ID;
    private String REVENUE;
    private String BANKING_DETAILS;
    private List<Email> EMAIL;
    private List<Phone> PHONE;
    private List<Messenger> IM;
    private List<Website> WEB;

    public void add_companyTitle(String title) {
       this.COMPANY_TYPE=title;
    }

    public void add_companyType(String companyType) {
        this.COMPANY_TYPE=companyType;
    }

    public void add_companyType(Company_type companyType) {
        this.COMPANY_TYPE=companyType.getCode();
    }

    public void add_comments(String comments) {
        this.COMMENTS=comments;
    }

    public void add_industryType(String industryType) {
        this.INDUSTRY=industryType;
    }

    public void add_industryType(Industry_type industryType) {
        this.INDUSTRY=industryType.getCode();
    }

    public void add_employeesType(String employeesType) {
        this.EMPLOYEES=employeesType;
    }

    public void add_employeesType(Employees_type employeesType) {
        this.EMPLOYEES=employeesType.getCode();
    }
}
