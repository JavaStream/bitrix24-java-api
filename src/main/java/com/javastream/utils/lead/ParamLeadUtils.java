package com.javastream.utils.lead;

import com.javastream.entity.Lead;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.MultiFields;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * ParamLeadUtils.
 *
 * @author javastream
 */
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

    public UriParamsCreator addMethod(Lead lead) throws UnsupportedEncodingException {
        UriParamsCreator params = createFieldsForAddMethod(lead);
        params.build();
        return params;
    }

    public UriParamsCreator getMethod(Integer idLead) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idLead.toString());
        params.build();
        return params;
    }

    public UriParamsCreator deleteMethod(Integer idLead) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idLead.toString());
        params.build();
        return params;
    }

    public UriParamsCreator updateMethod(Lead lead) throws UnsupportedEncodingException {
        UriParamsCreator params = createFieldsForUpdateMethod(lead);
        params.build();
        return params;
    }

    public UriParamsCreator getAllMethod() {
        UriParamsCreator params = new UriParamsCreator();
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

    private UriParamsCreator createFieldsForAddMethod(Lead lead) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();
        params.put(TITLE, check(lead.getTitle()));
        params.put(NAME, check(lead.getName()));
        params.put(LAST_NAME, check(lead.getLastName()));
        params.put(SECOND_NAME, check(lead.getSecondName()));
        params.put(ADDRESS_PROVINCE, check(lead.getAddressProvince()));
        params.put(ADDRESS_COUNTRY_CODE, check(lead.getAddressCountryCode()));
        params.put(ADDRESS_REGION, check(lead.getAddressRegion()));
        params.put(ADDRESS_COUNTRY, check(lead.getAddressCountry()));
        params.put(ADDRESS_CITY, check(lead.getAddressCity()));
        params.put(ADDRESS, check(lead.getAddress()));
        params.put(POST, check(lead.getPost()));
        params.put(ASSIGNED_BY_ID, check(lead.getAssignedById()));
        params.put(COMMENTS, check(lead.getComments()));
        params.put(COMPANY_ID, check(lead.getCompanyId()));
        params.put(CONTACT_ID, check(lead.getContactId()));
        params.put(STATUS_ID, check(lead.getStatusId()));
        params.put(CURRENCY_ID, check(lead.getCurrencyId()));
        params.put(SOURCE_ID, check(lead.getSourceId()));
        params.put(OPPORTUNITY, check(lead.getOpportunity().toString()));
        return createAdditionalParams(params, lead);
    }

    private UriParamsCreator createFieldsForUpdateMethod(Lead lead) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, lead.getId().toString());
        params.put(TITLE, check(lead.getTitle()));
        params.put(NAME, check(lead.getName()));
        params.put(LAST_NAME, check(lead.getLastName()));
        params.put(SECOND_NAME, check(lead.getSecondName()));
        params.put(ADDRESS_PROVINCE, check(lead.getAddressProvince()));
        params.put(ADDRESS_COUNTRY_CODE, check(lead.getAddressCountryCode()));
        params.put(ADDRESS_REGION, check(lead.getAddressRegion()));
        params.put(ADDRESS_COUNTRY, check(lead.getAddressCountry()));
        params.put(ADDRESS_CITY, check(lead.getAddressCity()));
        params.put(ADDRESS, check(lead.getAddress()));
        params.put(POST, check(lead.getPost()));
        params.put(COMMENTS, check(lead.getComments()));
        params.put(COMPANY_ID, check(lead.getCompanyId()));
        params.put(CONTACT_ID, check(lead.getContactId()));
        params.put(STATUS_ID, check(lead.getStatusId()));
        params.put(CURRENCY_ID, check(lead.getCurrencyId()));
        params.put(SOURCE_ID, check(lead.getSourceId()));
        params.put(OPPORTUNITY, check(lead.getOpportunity()));
        return createAdditionalParams(params, lead);
    }

    /**
     * Multiple parameters of Phone, Email, Web, Messenger
     */
    private UriParamsCreator createAdditionalParams(UriParamsCreator params, Lead lead) throws UnsupportedEncodingException {
        if (lead.getPhones() != null) {
            HashMap<String, String> photos = new MultiFields()
                    .getPhoneFields(lead.getPhones());
            for (Map.Entry<String, String> entry : photos.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        if (lead.getEmails() != null) {
            HashMap<String, String> emails = new MultiFields()
                    .getEmailFields(lead.getEmails());
            for (Map.Entry<String, String> entry : emails.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        if (lead.getWebsites() != null) {
            HashMap<String, String> webs = new MultiFields()
                    .getWebsiteFields(lead.getWebsites());
            for (Map.Entry<String, String> entry : webs.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        if (lead.getMessengers() != null) {
            HashMap<String, String> ims = new MultiFields()
                    .getMessengerFields(lead.getMessengers());
            for (Map.Entry<String, String> entry : ims.entrySet()) {
                String key = entry.getKey();
                String value = URLEncoder.encode(entry.getValue(), "UTF-8");
                params.put(key, value);
            }
        }

        return params;
    }
}