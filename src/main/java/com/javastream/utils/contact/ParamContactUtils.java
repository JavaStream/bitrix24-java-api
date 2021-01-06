package com.javastream.utils.contact;

import com.javastream.entity.Contact;
import com.javastream.uriParamsCreator.UriParamsCreator;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


@Service
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

    public UriParamsCreator getParamsForAddContact(Contact contact) throws UnsupportedEncodingException {
        UriParamsCreator params = initialFieldsForAddContact(contact);
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForDeleteContact(Integer idContact) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idContact.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForGetContact(Integer idContact) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idContact.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForUpdateContact(Contact contact) throws UnsupportedEncodingException {
        UriParamsCreator params = initialFieldsForUpdateContact(contact);
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

    private UriParamsCreator initialFieldsForAddContact(Contact contact) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();
        params.put(NAME, check(contact.getNAME()));
        params.put(LAST_NAME, check(contact.getLAST_NAME()));
        params.put(SECOND_NAME, check(contact.getSECOND_NAME()));
        params.put(ADDRESS_PROVINCE, check(contact.getADDRESS_PROVINCE()));
        params.put(ADDRESS_COUNTRY_CODE, check(contact.getADDRESS_COUNTRY_CODE()));
        params.put(ADDRESS_REGION, check(contact.getADDRESS_REGION()));
        params.put(ADDRESS_COUNTRY, check(contact.getADDRESS_COUNTRY()));
        params.put(ADDRESS_CITY, check(contact.getADDRESS_CITY()));
        params.put(ADDRESS, check(contact.getADDRESS()));
        params.put(POST, check(contact.getPOST()));
        params.put(EXPORT, check(contact.getEXPORT()));
        params.put(COMMENTS, check(contact.getCOMMENTS()));
        params.put(COMPANY_ID, check(contact.getCOMPANY_ID()));
        params.put(TYPE_ID, check(contact.getTYPE_ID()));

        return createFinalParams(params, contact);
    }

    private UriParamsCreator initialFieldsForUpdateContact(Contact contact) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, contact.getID().toString());
        params.put(NAME, check(contact.getNAME()));
        params.put(LAST_NAME, check(contact.getLAST_NAME()));
        params.put(SECOND_NAME, check(contact.getSECOND_NAME()));
        params.put(ADDRESS_PROVINCE, check(contact.getADDRESS_PROVINCE()));
        params.put(ADDRESS_COUNTRY_CODE, check(contact.getADDRESS_COUNTRY_CODE()));
        params.put(ADDRESS_REGION, check(contact.getADDRESS_REGION()));
        params.put(ADDRESS_COUNTRY, check(contact.getADDRESS_COUNTRY()));
        params.put(ADDRESS_CITY, check(contact.getADDRESS_CITY()));
        params.put(ADDRESS, check(contact.getADDRESS()));
        params.put(POST, check(contact.getPOST()));
        params.put(EXPORT, check(contact.getEXPORT()));
        params.put(COMMENTS, check(contact.getCOMMENTS()));
        params.put(COMPANY_ID, check(contact.getCOMPANY_ID()));
        params.put(TYPE_ID, check(contact.getTYPE_ID()));

        return createFinalParams(params, contact);
    }

    private UriParamsCreator createFinalParams(UriParamsCreator params, Contact contact) throws UnsupportedEncodingException {

        // Multiple parameter of Phone
        if (contact.getPHONE() != null) {
            HashMap<String, String> mapPhoto = new MultiFieldsForContactCreator().getPhotoFields(contact);
            for (Map.Entry<String, String> entry : mapPhoto.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        // Multiple parameter of Email
        if (contact.getEMAIL() != null) {
            HashMap<String, String> mapEmail = new MultiFieldsForContactCreator().getEmailFields(contact);
            for (Map.Entry<String, String> entry : mapEmail.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        // Multiple parameter of Web
        if (contact.getWEB() != null) {
            HashMap<String, String> mapWeb = new MultiFieldsForContactCreator().getWebsiteFields(contact);
            for (Map.Entry<String, String> entry : mapWeb.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        // Multiple parameter of Messenger
        if (contact.getIM() != null) {
            HashMap<String, String> mapIM = new MultiFieldsForContactCreator().getMessengerFields(contact);
            for (Map.Entry<String, String> entry : mapIM.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        return params;
    }
}