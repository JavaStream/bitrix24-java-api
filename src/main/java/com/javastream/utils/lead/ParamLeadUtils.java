package com.javastream.utils.lead;

import com.javastream.entity.Lead;
import com.javastream.uriParamsCreator.UriParamsCreator;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


@Service
public class ParamLeadUtils {

    private final static String ID = "id";
    private final static String SPACE_PARAM = "%20";
    private final static String TITLE = "FIELDS[TITLE]";
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
    private final static String ASSIGNED_BY_ID = "FIELDS[ASSIGNED_BY_ID]";
    private final static String COMMENTS = "FIELDS[COMMENTS]";
    private final static String COMPANY_ID = "FIELDS[COMPANY_ID]";
    private final static String CONTACT_ID = "FIELDS[CONTACT_ID]";
    private final static String STATUS_ID = "FIELDS[STATUS_ID]";
    private final static String CURRENCY_ID = "FIELDS[CURRENCY_ID]";
    private final static String SOURCE_ID = "FIELDS[SOURCE_ID]";
    private final static String OPPORTUNITY = "FIELDS[OPPORTUNITY]";

    public UriParamsCreator getParamsForAddLead(Lead lead) throws UnsupportedEncodingException {
        UriParamsCreator params = initialFieldsForAddLead(lead);
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForGetLead(Integer idLead) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idLead.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForDeleteLead(Integer idLead) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idLead.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForUpdateLead(Lead lead) throws UnsupportedEncodingException {
        UriParamsCreator params = initialFieldsForUpdateLead(lead);
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

    private UriParamsCreator initialFieldsForAddLead(Lead lead) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();

        params.put(TITLE, check(lead.getTITLE()));
        params.put(NAME, check(lead.getNAME()));
        params.put(LAST_NAME, check(lead.getLAST_NAME()));
        params.put(SECOND_NAME, check(lead.getSECOND_NAME()));
        params.put(ADDRESS_PROVINCE, check(lead.getADDRESS_PROVINCE()));
        params.put(ADDRESS_COUNTRY_CODE, check(lead.getADDRESS_COUNTRY_CODE()));
        params.put(ADDRESS_REGION, check(lead.getADDRESS_REGION()));
        params.put(ADDRESS_COUNTRY, check(lead.getADDRESS_COUNTRY()));
        params.put(ADDRESS_CITY, check(lead.getADDRESS_CITY()));
        params.put(ADDRESS, check(lead.getADDRESS()));
        params.put(POST, check(lead.getPOST()));
        params.put(ASSIGNED_BY_ID, check(lead.getASSIGNED_BY_ID()));
        params.put(COMMENTS, check(lead.getCOMMENTS()));
        params.put(COMPANY_ID, check(lead.getCOMPANY_ID()));
        params.put(CONTACT_ID, check(lead.getCONTACT_ID()));
        params.put(STATUS_ID, check(lead.getSTATUS_ID()));
        params.put(CURRENCY_ID, check(lead.getCURRENCY_ID()));
        params.put(SOURCE_ID, check(lead.getSOURCE_ID()));
        params.put(OPPORTUNITY, check(lead.getOPPORTUNITY().toString()));

        return createFinalParams(params, lead);
    }

    private UriParamsCreator initialFieldsForUpdateLead(Lead lead) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, lead.getID().toString());
        params.put(TITLE, check(lead.getTITLE()));
        params.put(NAME, check(lead.getNAME()));
        params.put(LAST_NAME, check(lead.getLAST_NAME()));
        params.put(SECOND_NAME, check(lead.getSECOND_NAME()));
        params.put(ADDRESS_PROVINCE, check(lead.getADDRESS_PROVINCE()));
        params.put(ADDRESS_COUNTRY_CODE, check(lead.getADDRESS_COUNTRY_CODE()));
        params.put(ADDRESS_REGION, check(lead.getADDRESS_REGION()));
        params.put(ADDRESS_COUNTRY, check(lead.getADDRESS_COUNTRY()));
        params.put(ADDRESS_CITY, check(lead.getADDRESS_CITY()));
        params.put(ADDRESS, check(lead.getADDRESS()));
        params.put(POST, check(lead.getPOST()));
        params.put(COMMENTS, check(lead.getCOMMENTS()));
        params.put(COMPANY_ID, check(lead.getCOMPANY_ID()));
        params.put(CONTACT_ID, check(lead.getCONTACT_ID()));
        params.put(STATUS_ID, check(lead.getSTATUS_ID()));
        params.put(CURRENCY_ID, check(lead.getCURRENCY_ID()));
        params.put(SOURCE_ID, check(lead.getSOURCE_ID()));
        params.put(OPPORTUNITY, check(lead.getOPPORTUNITY()));

        return createFinalParams(params, lead);
    }

    private UriParamsCreator createFinalParams(UriParamsCreator params, Lead lead) throws UnsupportedEncodingException {

        // Multiple parameter of Phone
        if (lead.getPHONE() != null) {
            HashMap<String, String> photos = new MultiFieldsForLeadCreator().getPhotoFields(lead);
            for (Map.Entry<String, String> entry : photos.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        // Multiple parameter of Email
        if (lead.getEMAIL() != null) {
            HashMap<String, String> emails = new MultiFieldsForLeadCreator().getEmailFields(lead);
            for (Map.Entry<String, String> entry : emails.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        // Multiple parameter of Web
        if (lead.getWEB() != null) {
            HashMap<String, String> webs = new MultiFieldsForLeadCreator().getWebsiteFields(lead);
            for (Map.Entry<String, String> entry : webs.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        // Multiple parameter of Messenger
        if (lead.getIM() != null) {
            HashMap<String, String> ims = new MultiFieldsForLeadCreator().getMessengerFields(lead);
            for (Map.Entry<String, String> entry : ims.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        return params;
    }


}