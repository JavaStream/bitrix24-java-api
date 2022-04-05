package com.javastream.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javastream.entity.Company;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.PushRunner;
import com.javastream.utils.company.ParamCompanyUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
    private final static String LIST_METHOD = "crm.company.list";

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

    public List<Company> getAll() {
        logger.info("Request: Get list of company");
        UriParamsCreator params = new ParamCompanyUtils().getAllMethod();
        JSONObject json = PushRunner.get(params, LIST_METHOD);
        JSONArray result = json.getJSONArray("result");
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<Company>>(){}.getType();
        return gson.fromJson(result.toString(), type);
    }
}
