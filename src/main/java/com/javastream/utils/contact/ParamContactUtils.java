package com.javastream.utils.contact;

import com.javastream.entity.Contact;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.MultiFields;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class ParamContactUtils {
    private final static String ID = "id";
    private final static String SPACE_PARAM = "%20";
    private final static String COMPANY_ID = "FIELDS[COMPANY_ID]";
    private final static String NAME = "FIELDS[NAME]";
    private final static String LAST_NAME = "FIELDS[LAST_NAME]";
    private final static String SECOND_NAME = "FIELDS[SECOND_NAME]";
    private final static String ADDRESS_PROVINCE = "FIELDS[ADDRESS_PROVINCE]";
    private final static String ADDRESS_COUNTRY_CODE = "FIELDS[ADDRESS_COUNTRY_CODE]";
    private final static String ADDRESS_REGION = "FIELDS[ADDRESS_REGION]";
    private final static String ADDRESS_COUNTRY = "FIELDS[ADDRESS_COUNTRY]";
    private final static String ADDRESS_CITY = "FIELDS[ADDRESS_CITY]";
    private final static String ADDRESS = "FIELDS[ADDRESS]";
    private final static String POST = "FIELDS[POST]";
    private final static String EXPORT = "FIELDS[EXPORT]";
    private final static String COMMENTS = "FIELDS[COMMENTS]";
    private final static String TYPE_ID = "FIELDS[TYPE_ID]";

    public UriParamsCreator addMethod(Contact contact) throws UnsupportedEncodingException {
        UriParamsCreator params = createFieldsForAddMethod(contact);
        params.build();
        return params;
    }

    public UriParamsCreator deleteMethod(Integer idContact) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idContact.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getMethod(Integer idContact) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idContact.toString());
        params.build();
        return params;
    }

    public UriParamsCreator updateMethod(Contact contact) throws UnsupportedEncodingException {
        UriParamsCreator params = createFieldsForUpdateMethod(contact);
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

    public UriParamsCreator getParamsForContactCompanyAdd(Integer idContact, Integer idCompany) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idContact.toString());
        params.put(COMPANY_ID, idCompany.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForContactCompanyDelete(Integer idContact, Integer idCompany) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idContact.toString());
        params.put(COMPANY_ID, idCompany.toString());
        params.build();
        return params;
    }

    private UriParamsCreator createFieldsForAddMethod(Contact contact) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();
        params.put(NAME, check(contact.getName()));
        params.put(LAST_NAME, check(contact.getLastName()));
        params.put(SECOND_NAME, check(contact.getSecondName()));
        params.put(ADDRESS_PROVINCE, check(contact.getAddressProvince()));
        params.put(ADDRESS_COUNTRY_CODE, check(contact.getAddressCountryCode()));
        params.put(ADDRESS_REGION, check(contact.getAddressRegion()));
        params.put(ADDRESS_COUNTRY, check(contact.getAddressCountry()));
        params.put(ADDRESS_CITY, check(contact.getAddressCity()));
        params.put(ADDRESS, check(contact.getAddress()));
        params.put(POST, check(contact.getPost()));
        params.put(EXPORT, check(contact.getExport()));
        params.put(COMMENTS, check(contact.getComments()));
        params.put(COMPANY_ID, check(contact.getCompanyId()));
        params.put(TYPE_ID, check(contact.getTypeId()));
        return createFinalParams(params, contact);
    }

    private UriParamsCreator createFieldsForUpdateMethod(Contact contact) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, contact.getId().toString());
        params.put(NAME, check(contact.getName()));
        params.put(LAST_NAME, check(contact.getLastName()));
        params.put(SECOND_NAME, check(contact.getSecondName()));
        params.put(ADDRESS_PROVINCE, check(contact.getAddressProvince()));
        params.put(ADDRESS_COUNTRY_CODE, check(contact.getAddressCountryCode()));
        params.put(ADDRESS_REGION, check(contact.getAddressRegion()));
        params.put(ADDRESS_COUNTRY, check(contact.getAddressCountry()));
        params.put(ADDRESS_CITY, check(contact.getAddressCity()));
        params.put(ADDRESS, check(contact.getAddress()));
        params.put(POST, check(contact.getPost()));
        params.put(EXPORT, check(contact.getExport()));
        params.put(COMMENTS, check(contact.getComments()));
        params.put(COMPANY_ID, check(contact.getCompanyId()));
        params.put(TYPE_ID, check(contact.getTypeId()));
        return createFinalParams(params, contact);
    }

    /**
     * Multiple parameters of Phone, Email, Web, Messenger
     */
    private UriParamsCreator createFinalParams(UriParamsCreator params, Contact contact) throws UnsupportedEncodingException {
        if (contact.getPhones() != null) {
            HashMap<String, String> mapPhoto = new MultiFields()
                    .getPhoneFields(contact.getPhones());
            for (Map.Entry<String, String> entry : mapPhoto.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        if (contact.getEmails() != null) {
            HashMap<String, String> mapEmail = new MultiFields()
                    .getEmailFields(contact.getEmails());
            for (Map.Entry<String, String> entry : mapEmail.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        if (contact.getWebsites() != null) {
            HashMap<String, String> mapWeb = new MultiFields()
                    .getWebsiteFields(contact.getWebsites());
            for (Map.Entry<String, String> entry : mapWeb.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        if (contact.getMessengers() != null) {
            HashMap<String, String> mapIM = new MultiFields()
                    .getMessengerFields(contact.getMessengers());
            for (Map.Entry<String, String> entry : mapIM.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        return params;
    }
}