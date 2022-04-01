package com.javastream.service;

import com.google.gson.Gson;
import com.javastream.entity.Company;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.PushRunner;
import com.javastream.utils.company.ParamCompanyUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * CompanyService.
 *
 * @author javastream
 */
public class CompanyService {

    private Logger logger = LoggerFactory.getLogger(CompanyService.class);

    private final static String ADD_METHOD = "crm.company.add";
    private final static String GET_METHOD = "crm.company.get";
    private final static String DELETE_METHOD = "crm.company.delete";
    private final static String UPDATE_METHOD = "crm.company.update";

    public void add(Company company) {
        logger.info("Request to add a new company: {}", company.getTitle());
        try {
            UriParamsCreator params = new ParamCompanyUtils().addMethod(company);
            PushRunner.post(params, ADD_METHOD);
        } catch (UnsupportedEncodingException e) {
            logger.error("An error occurred while adding new company", e);
        }
    }

    public Company get(Integer idCompany) {
        logger.info("Request to get the company by id: {}", idCompany);
        UriParamsCreator params = new ParamCompanyUtils().getMethod(idCompany);
        JSONObject jsonMain = PushRunner.get(params, GET_METHOD);
        JSONObject jsonResult = jsonMain.getJSONObject("result");
        Gson gson = new Gson();
        return gson.fromJson(jsonResult.toString(), Company.class);
    }

    public void delete(Integer idCompany) {
        logger.info("Request to delete the company by id: {}", idCompany);
        UriParamsCreator params = new ParamCompanyUtils().deleteMethod(idCompany);
        PushRunner.post(params, DELETE_METHOD);
    }

    public void update(Company company) {
        logger.info("Request to update the company, id: {}, title: {}", company.getId(), company.getTitle());
        try {
            UriParamsCreator params = new ParamCompanyUtils().updateMethod(company);
            PushRunner.post(params, UPDATE_METHOD);
        } catch (UnsupportedEncodingException e) {
            logger.error("An error occurred while updating company", e);
        }
    }
}
