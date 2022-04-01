package com.javastream.service;

import com.google.gson.Gson;
import com.javastream.entity.Lead;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.PushRunner;
import com.javastream.utils.lead.ParamLeadUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * LeadService.
 *
 * @author javastream
 */
public class LeadService {

    private Logger logger = LoggerFactory.getLogger(LeadService.class);

    private final static String ADD_METHOD = "crm.lead.add";
    private final static String GET_METHOD = "crm.lead.get";
    private final static String DELETE_METHOD = "crm.lead.delete";
    private final static String UPDATE_METHOD = "crm.lead.update";

    public void add(Lead lead) {
        logger.info("Request: Add a new lead: {}", lead.getId());
        try {
            UriParamsCreator params = new ParamLeadUtils().addMethod(lead);
            PushRunner.post(params, ADD_METHOD);
        } catch (UnsupportedEncodingException e) {
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
}