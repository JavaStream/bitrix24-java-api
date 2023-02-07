package com.javastream.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javastream.entity.Lead;
import com.javastream.entity.model.Phone;
import com.javastream.service.exceptions.LeadServiceException;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.PushRunner;
import com.javastream.utils.lead.ParamLeadUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * LeadService.
 *
 * @author javastream
 */
public final class LeadService {

    private final Logger logger = LoggerFactory.getLogger(LeadService.class);

    private final static String ADD_METHOD = "crm.lead.add";
    private final static String GET_METHOD = "crm.lead.get";
    private final static String DELETE_METHOD = "crm.lead.delete";
    private final static String UPDATE_METHOD = "crm.lead.update";
    private final static String LIST_METHOD = "crm.lead.list";

    public void add(Lead lead) {
        try {
            this.validate(lead);
        } catch (LeadServiceException e) {
            throw new RuntimeException(e);
        }
        logger.info("Request: Add a new lead.");
        try {
            UriParamsCreator params = new ParamLeadUtils().addMethod(lead);
            JSONObject result = PushRunner.post(params, ADD_METHOD);
            assert result != null;
            Integer leadId = Integer.parseInt(result.get("result").toString());
            lead.setId(leadId);
            logger.info("Added new lead with ID: " + leadId);
        } catch (UnsupportedEncodingException|NumberFormatException e) {
            logger.error("An error occurred while adding new lead", e);
        }
    }

    public Lead get(Integer idLead) {
        logger.info("Request: Get the lead by id: {}", idLead);
        UriParamsCreator params = new ParamLeadUtils().getMethod(idLead);
        JSONObject json = PushRunner.get(params, GET_METHOD);
        JSONObject result = json.getJSONObject("result");
        Gson gson = new Gson();
        return gson.fromJson(result.toString(), Lead.class);
    }

    public void delete(Integer idLead) {
        logger.info("Request: Delete the lead by id: {}", idLead);
        UriParamsCreator params = new ParamLeadUtils().deleteMethod(idLead);
        PushRunner.post(params, DELETE_METHOD);
    }

    // TODO delete by Lead

    public void update(Lead lead) {
        logger.info("Request: Update the lead by id: {}, title: {}", lead.getId(), lead.getTitle());
        try {
            UriParamsCreator params = new ParamLeadUtils().updateMethod(lead);
            PushRunner.post(params, UPDATE_METHOD);
        } catch (UnsupportedEncodingException e) {
            logger.error("An error occurred while updating lead", e);
        }
    }

    public List<Lead> getAll() {
        logger.info("Request: Get list of leads");
        UriParamsCreator params = new ParamLeadUtils().getAllMethod();
        JSONObject json = PushRunner.get(params, LIST_METHOD);
        JSONArray result = json.getJSONArray("result");
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<Lead>>(){}.getType();
        return gson.fromJson(result.toString(), type);
    }

    private void validate(Lead lead) throws LeadServiceException {
        if(lead.getOpportunity() == null) {
            logger.warn("Lead opportunity is not set, setting 0 as a default.");
            lead.setOpportunity("0");
        }
        for (Phone p:lead.getPhones()) {
            if (p.getValueType() == null) {
                throw new LeadServiceException("Phone type for phone number " + p.getValue() + " is not set.");
            }
        }
    }
}