package com.javastream.service;

import com.google.gson.Gson;
import com.javastream.entity.ProductSection;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.PushRunner;
import com.javastream.utils.productSection.ParamProductSectionUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProductSectionService.
 *
 * @author javastream
 */
public class ProductSectionService {

    private Logger logger = LoggerFactory.getLogger(ProductSectionService.class);

    private final static String ADD_METHOD = "crm.productsection.add";
    private final static String DELETE_METHOD = "crm.productsection.delete";
    private final static String GET_METHOD = "crm.productsection.get";
    private final static String UPDATE_METHOD = "crm.productsection.update";

    public void add(ProductSection productSection) {
        logger.info("Request: Add a new product section: {}", productSection.getName());
        UriParamsCreator params = new ParamProductSectionUtils().addMethod(productSection);
        PushRunner.post(params, ADD_METHOD);
    }

    public void delete(Integer idSection) {
        logger.info("Request: Delete the product section by id: {}", idSection);
        UriParamsCreator params = new ParamProductSectionUtils().deleteMethod(idSection);
        PushRunner.post(params, DELETE_METHOD);
    }

    public ProductSection get(Integer idSection) {
        logger.info("Request: Get the product section by id: {}", idSection);
        UriParamsCreator params = new ParamProductSectionUtils().getMethod(idSection);
        JSONObject jsonMain = PushRunner.get(params, GET_METHOD);
        JSONObject jsonResult = jsonMain.getJSONObject("result");
        Gson gson = new Gson();
        return gson.fromJson(jsonResult.toString(), ProductSection.class);
    }

    public void update(ProductSection productSection) {
        logger.info("Request: Update the product section by id: {}, name: {}", productSection.getId(), productSection.getName());
        UriParamsCreator params = new ParamProductSectionUtils().updateMethod(productSection);
        PushRunner.post(params, UPDATE_METHOD);
    }
}