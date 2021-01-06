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

public class CompanyService {

    private Logger logger = LoggerFactory.getLogger(CompanyService.class);

    private final static String ADD_METHOD = "crm.company.add";
    private final static String GET_METHOD = "crm.company.get";
    private final static String DELETE_METHOD = "crm.company.delete";
    private final static String UPDATE_METHOD = "crm.company.update";

    public void addNewCompany(Company company)  {
        logger.info("Request to add a new company: {}", company.getTITLE());
        try {
            UriParamsCreator params = new ParamCompanyUtils().getParamsForAddCompany(company);
            PushRunner.post(params, ADD_METHOD);
        }catch (UnsupportedEncodingException e) {
            logger.error("An error occurred while adding new company", e);
        }
    }

    public Company getCompanyById(Integer idCompany) {
        logger.info("Request to get the company by id: {}", idCompany);
        UriParamsCreator params = new ParamCompanyUtils().getParamsForGetCompany(idCompany);
        JSONObject jsonMain = PushRunner.get(params, GET_METHOD);
        JSONObject jsonResult = jsonMain.getJSONObject("result");
        Gson gson = new Gson();
        return gson.fromJson(jsonResult.toString(), Company.class);
    }

    public void deleteCompanyById(Integer idCompany)  {
        logger.info("Request to delete the company by id: {}", idCompany);
        UriParamsCreator params = new ParamCompanyUtils().getParamsForDeleteCompany(idCompany);
        PushRunner.post(params, DELETE_METHOD);
    }

    public void updateCompany(Company company)  {
        logger.info("Request to update the company, id: {}, title: {}", company.getID(), company.getTITLE());
        try {
            UriParamsCreator params = new ParamCompanyUtils().getParamsForUpdateCompany(company);
            PushRunner.post(params, UPDATE_METHOD);
        } catch (UnsupportedEncodingException e) {
            logger.error("An error occurred while updating company", e);
        }
    }
}
