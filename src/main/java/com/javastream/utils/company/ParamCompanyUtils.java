package com.javastream.utils.company;

import com.javastream.entity.Company;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.MultiFields;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


/**
 * ParamCompanyUtils.
 *
 * @author javastream
 */
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

    public UriParamsCreator addMethod(Company company) throws UnsupportedEncodingException {
        UriParamsCreator params = createFieldsForAddMethod(company);
        params.build();
        return params;
    }

    public UriParamsCreator getMethod(Integer idCompany) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idCompany.toString());
        params.build();
        return params;
    }

    public UriParamsCreator deleteMethod(Integer idCompany) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idCompany.toString());
        params.build();
        return params;
    }

    public UriParamsCreator updateMethod(Company company) throws UnsupportedEncodingException {
        UriParamsCreator params = createFieldsForUpdateMethod(company);
        params.build();
        return params;
    }

    private String check(String field) {
        if (field == null) {
            return SPACE_PARAM;
        } else {
            return URLEncoder.encode(field);
        }
    }

    private UriParamsCreator createFieldsForAddMethod(Company company) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();
        params.put(TITLE, check(company.getTitle()));
        params.put(ADDRESS_PROVINCE, check(company.getAddressProvince()));
        params.put(ADDRESS_COUNTRY_CODE, check(company.getAddressCountryCode()));
        params.put(ADDRESS_COUNTRY, check(company.getAddressCountry()));
        params.put(ADDRESS_REGION, check(company.getAddressRegion()));
        params.put(ADDRESS_CITY, check(company.getAddressCity()));
        params.put(ADDRESS, check(company.getAddress()));
        params.put(ADDRESS_2, check(company.getAddressAdditional()));
        params.put(ADDRESS_LEGAL, check(company.getAddressLegal()));
        params.put(COMMENTS, check(company.getComments()));
        params.put(OPENED, check(company.getOpened()));
        params.put(COMPANY_TYPE, check(company.getCompanyType()));
        params.put(INDUSTRY, check(company.getIndustry()));
        params.put(EMPLOYEES, check(company.getEmployees()));
        params.put(LEAD_ID, check(company.getLeadId()));
        params.put(BANKING_DETAILS, check(company.getBankingDetails()));
        return createFinalParams(params, company);
    }

    private UriParamsCreator createFieldsForUpdateMethod(Company company) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, company.getId().toString());
        params.put(TITLE, check(company.getTitle()));
        params.put(ADDRESS_PROVINCE, check(company.getAddressProvince()));
        params.put(ADDRESS_COUNTRY_CODE, check(company.getAddressCountryCode()));
        params.put(ADDRESS_COUNTRY, check(company.getAddressCountry()));
        params.put(ADDRESS_REGION, check(company.getAddressRegion()));
        params.put(ADDRESS_CITY, check(company.getAddressCity()));
        params.put(ADDRESS, check(company.getAddress()));
        params.put(ADDRESS_2, check(company.getAddressAdditional()));
        params.put(ADDRESS_LEGAL, check(company.getAddressLegal()));
        params.put(COMMENTS, check(company.getComments()));
        params.put(OPENED, check(company.getOpened()));
        params.put(COMPANY_TYPE, check(company.getCompanyType()));
        params.put(INDUSTRY, check(company.getIndustry()));
        params.put(EMPLOYEES, check(company.getEmployees()));
        params.put(LEAD_ID, check(company.getLeadId()));
        params.put(BANKING_DETAILS, check(company.getBankingDetails()));
        return createFinalParams(params, company);
    }

    /**
     * Multiple parameters of Phone, Email, Web, Messenger
     */
    private UriParamsCreator createFinalParams(UriParamsCreator params, Company company) throws UnsupportedEncodingException {
        if (company.getPhones() != null) {
            HashMap<String, String> mapPhoto = new MultiFields()
                    .getPhoneFields(company.getPhones());
            for (Map.Entry<String, String> entry : mapPhoto.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        if (company.getEmails() != null) {
            HashMap<String, String> mapEmail = new MultiFields()
                    .getEmailFields(company.getEmails());
            for (Map.Entry<String, String> entry : mapEmail.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        if (company.getWebsites() != null) {
            HashMap<String, String> mapWeb = new MultiFields()
                    .getWebsiteFields(company.getWebsites());
            for (Map.Entry<String, String> entry : mapWeb.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        if (company.getMessengers() != null) {
            HashMap<String, String> mapIM = new MultiFields()
                    .getMessengerFields(company.getMessengers());
            for (Map.Entry<String, String> entry : mapIM.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        return params;
    }
}