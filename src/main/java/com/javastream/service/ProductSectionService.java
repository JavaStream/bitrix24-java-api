package com.javastream.service;

import com.google.gson.Gson;
import com.javastream.entity.ProductSection;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.PushRunner;
import com.javastream.utils.productSection.ParamProductSectionUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductSectionService {

    private Logger logger = LoggerFactory.getLogger(ProductSectionService.class);

    private final static String ADD_METHOD = "crm.productsection.add";
    private final static String DELETE_METHOD = "crm.productsection.delete";
    private final static String GET_METHOD = "crm.productsection.get";
    private final static String UPDATE_METHOD = "crm.productsection.update";

    public void addProductSection(ProductSection productSection) {
        logger.info("Request: Add a new product section: {}", productSection.getNAME());
        UriParamsCreator params = new ParamProductSectionUtils().getParamsForAddProductSection(productSection);
        PushRunner.post(params, ADD_METHOD);
    }

    public void deleteProductSection(Integer idSection) {
        logger.info("Request: Delete the product section by id: {}", idSection);
        UriParamsCreator params = new ParamProductSectionUtils().getParamsForDeleteProductSection(idSection);
        PushRunner.post(params, DELETE_METHOD);
    }

    public ProductSection getProductSection(Integer idSection) {
        logger.info("Request: Get the product section by id: {}", idSection);
        UriParamsCreator params = new ParamProductSectionUtils().getParamsForGetProductSection(idSection);
        JSONObject jsonMain = PushRunner.get(params, GET_METHOD);
        JSONObject jsonResult = jsonMain.getJSONObject("result");
        Gson gson = new Gson();
        return gson.fromJson(jsonResult.toString(), ProductSection.class);
    }

    public void updateProductSection(ProductSection productSection) {
        logger.info("Request: Update the product section by id: {}, name: {}", productSection.getID(), productSection.getNAME());
        UriParamsCreator params = new ParamProductSectionUtils().getParamsForUpdateProductSection(productSection);
        PushRunner.post(params, UPDATE_METHOD);
    }
}
