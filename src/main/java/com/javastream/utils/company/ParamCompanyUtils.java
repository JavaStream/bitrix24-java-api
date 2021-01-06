package com.javastream.utils.company;

import com.javastream.entity.Company;
import com.javastream.uriParamsCreator.UriParamsCreator;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


@Service
public class ParamCompanyUtils {

    private final static String ID = "id";
    private final static String SPACE_PARAM = "%20";

    private final static String TITLE = "FIELDS[TITLE]";
    private final static String ADDRESS_PROVINCE = "FIELDS[ADDRESS_PROVINCE]";
    private final static String ADDRESS_COUNTRY_CODE = "FIELDS[ADDRESS_COUNTRY_CODE]";
    private final static String ADDRESS_COUNTRY = "FIELDS[ADDRESS_COUNTRY]";
    private final static String ADDRESS_REGION = "FIELDS[ADDRESS_REGION]";
    private final static String ADDRESS_CITY = "FIELDS[ADDRESS_CITY]";
    private final static String ADDRESS = "FIELDS[ADDRESS]";
    private final static String ADDRESS_2 = "FIELDS[ADDRESS_2]";
    private final static String ADDRESS_LEGAL = "FIELDS[ADDRESS_LEGAL]";
    private final static String COMMENTS = "FIELDS[COMMENTS]";
    private final static String OPENED = "FIELDS[OPENED]";
    private final static String COMPANY_TYPE = "FIELDS[COMPANY_TYPE]";
    private final static String INDUSTRY = "FIELDS[INDUSTRY]";
    private final static String EMPLOYEES = "FIELDS[EMPLOYEES]";
    private final static String LEAD_ID = "FIELDS[LEAD_ID]";
    private final static String BANKING_DETAILS = "FIELDS[BANKING_DETAILS]";


    public UriParamsCreator getParamsForAddCompany(Company company) throws UnsupportedEncodingException {
        UriParamsCreator params = initialFieldsForAddCompany(company);
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForGetCompany(Integer idCompany) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idCompany.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForDeleteCompany(Integer idCompany) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idCompany.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForUpdateCompany(Company company) throws UnsupportedEncodingException {
        UriParamsCreator params = initialFieldsForUpdateCompany(company);
        params.build();
        return params;
    }

    private String check(String field) {
        if (field == null) {
            return SPACE_PARAM;
        } else {
            return URLEncoder.encode(field.toString());
        }
    }

    private UriParamsCreator initialFieldsForAddCompany(Company company) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();

        params.put(TITLE, check(company.getTITLE()));
        params.put(ADDRESS_PROVINCE, check(company.getADDRESS_PROVINCE()));
        params.put(ADDRESS_COUNTRY_CODE, check(company.getADDRESS_COUNTRY_CODE()));
        params.put(ADDRESS_COUNTRY, check(company.getADDRESS_COUNTRY()));
        params.put(ADDRESS_REGION, check(company.getADDRESS_REGION()));
        params.put(ADDRESS_CITY, check(company.getADDRESS_CITY()));
        params.put(ADDRESS, check(company.getADDRESS()));
        params.put(ADDRESS_2, check(company.getADDRESS_2()));
        params.put(ADDRESS_LEGAL, check(company.getADDRESS_LEGAL()));
        params.put(COMMENTS, check(company.getCOMMENTS()));
        params.put(OPENED, check(company.getOPENED()));
        params.put(COMPANY_TYPE, check(company.getCOMPANY_TYPE()));
        params.put(INDUSTRY, check(company.getINDUSTRY()));
        params.put(EMPLOYEES, check(company.getEMPLOYEES()));
        params.put(LEAD_ID, check(company.getLEAD_ID()));
        params.put(BANKING_DETAILS, check(company.getBANKING_DETAILS()));

        return createFinalParams(params, company);
    }

    private UriParamsCreator initialFieldsForUpdateCompany(Company company) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();

        params.put(ID, company.getID().toString());
        params.put(TITLE, check(company.getTITLE()));
        params.put(ADDRESS_PROVINCE, check(company.getADDRESS_PROVINCE()));
        params.put(ADDRESS_COUNTRY_CODE, check(company.getADDRESS_COUNTRY_CODE()));
        params.put(ADDRESS_COUNTRY, check(company.getADDRESS_COUNTRY()));
        params.put(ADDRESS_REGION, check(company.getADDRESS_REGION()));
        params.put(ADDRESS_CITY, check(company.getADDRESS_CITY()));
        params.put(ADDRESS, check(company.getADDRESS()));
        params.put(ADDRESS_2, check(company.getADDRESS_2()));
        params.put(ADDRESS_LEGAL, check(company.getADDRESS_LEGAL()));
        params.put(COMMENTS, check(company.getCOMMENTS()));
        params.put(OPENED, check(company.getOPENED()));
        params.put(COMPANY_TYPE, check(company.getCOMPANY_TYPE()));
        params.put(INDUSTRY, check(company.getINDUSTRY()));
        params.put(EMPLOYEES, check(company.getEMPLOYEES()));
        params.put(LEAD_ID, check(company.getLEAD_ID()));
        params.put(BANKING_DETAILS, check(company.getBANKING_DETAILS()));

        return createFinalParams(params, company);
    }

    private UriParamsCreator createFinalParams(UriParamsCreator params, Company company) throws UnsupportedEncodingException {

        //Множественный параметр Phone
        if (company.getPHONE() != null) {
            HashMap<String, String> mapPhoto = new MultiFieldsForCompanyCreator().getPhotoFields(company);
            for (Map.Entry<String, String> entry : mapPhoto.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }


        //Множественный параметр Email
        if (company.getEMAIL() != null) {
            HashMap<String, String> mapEmail = new MultiFieldsForCompanyCreator().getEmailFields(company);
            for (Map.Entry<String, String> entry : mapEmail.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        //Множественный параметр Web
        if (company.getWEB() != null) {
            HashMap<String, String> mapWeb = new MultiFieldsForCompanyCreator().getWebsiteFields(company);
            for (Map.Entry<String, String> entry : mapWeb.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        //Множественный параметр Messenger
        if (company.getIM() != null) {
            HashMap<String, String> mapIM = new MultiFieldsForCompanyCreator().getMessengerFields(company);
            for (Map.Entry<String, String> entry : mapIM.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        return params;
    }
}