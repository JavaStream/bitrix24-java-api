package com.javastream.service;

import com.google.gson.Gson;
import com.javastream.entity.Contact;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.PushRunner;
import com.javastream.utils.contact.ParamContactUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

public class ContactService {

    private Logger logger = LoggerFactory.getLogger(ContactService.class);

    private final static String ADD_METHOD = "crm.contact.add";
    private final static String DELETE_METHOD = "crm.contact.delete";
    private final static String GET_METHOD = "crm.contact.get";
    private final static String UPDATE_METHOD = "crm.contact.update";
    private final static String DELETE_FROM_COMPANY_METHOD = "crm.contact.company.delete";

    public void addNewContact(Contact contact)  {
        logger.info("Request: Add a new contact: {}", contact.getNAME());
        try {
            UriParamsCreator params = new ParamContactUtils().getParamsForAddContact(contact);
            PushRunner.post(params, ADD_METHOD);
        } catch (UnsupportedEncodingException e) {
            logger.error("An error occurred while adding new contact", e);
    }

    }

    public void deleteContactById(Integer idContact)  {
        logger.info("Request: Delete the contact by id: {}", idContact);
        UriParamsCreator params = new ParamContactUtils().getParamsForDeleteContact(idContact);
        PushRunner.post(params, DELETE_METHOD);
    }

    public Contact getContactById(Integer idContact) {
        logger.info("Request: Get the contact by id: {}", idContact);
        UriParamsCreator params = new ParamContactUtils().getParamsForGetContact(idContact);
        JSONObject jsonMain = PushRunner.get(params, GET_METHOD);
        JSONObject jsonResult = jsonMain.getJSONObject("result");
        Gson gson = new Gson();
        return gson.fromJson(jsonResult.toString(), Contact.class);
    }

    public void updateContact(Contact contact)  {
        logger.info("Request: Update the contact by id: {}, name: {}", contact.getID(), contact.getNAME());
        try {
            UriParamsCreator params = new ParamContactUtils().getParamsForUpdateContact(contact);
            PushRunner.post(params, UPDATE_METHOD);
        } catch (UnsupportedEncodingException e) {
            logger.error("An error occurred while updating contact {}", contact.getID(), e);
        }
    }

    public void addCompanyIntoExistingContactById(Integer idContact, Integer idCompany)  {
        UriParamsCreator params = new ParamContactUtils().getParamsForContactCompanyAdd(idContact, idCompany);
        PushRunner.post(params, "uriParams");
    }

    public void deleteCompanyFromExistingContactById(Integer idContact, Integer idCompany)  {
        UriParamsCreator params = new ParamContactUtils().getParamsForContactCompanyDelete(idContact, idCompany);
        PushRunner.post(params, DELETE_FROM_COMPANY_METHOD);
    }
}
