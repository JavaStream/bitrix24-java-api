package com.javastream.service;

import com.google.gson.Gson;
import com.javastream.entity.Product;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.PushRunner;
import com.javastream.utils.product.ParamProductUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

public class ProductService {

    private Logger logger = LoggerFactory.getLogger(LeadService.class);

    private final static String ADD_METHOD = "crm.product.add";
    private final static String DELETE_METHOD = "crm.product.delete";
    private final static String GET_METHOD = "crm.product.get";
    private final static String UPDATE_METHOD = "crm.product.update";

    public void addProduct(Product product) {
        logger.info("Request: Add a new product: {}", product.getID());
        UriParamsCreator params = new ParamProductUtils().getParamsForAddProduct(product);
        PushRunner.post(params, ADD_METHOD);
    }

    public void deleteProduct(Integer idProduct) {
        logger.info("Request: Delete the product by id: {}", idProduct);
        UriParamsCreator params = new ParamProductUtils().getParamsForDeleteProduct(idProduct);
        PushRunner.post(params, DELETE_METHOD);
    }

    public Product getProduct(Integer idProduct) {
        logger.info("Request: Get the product by id: {}", idProduct);
        UriParamsCreator params = new ParamProductUtils().getParamsForGetProduct(idProduct);
        JSONObject jsonMain = PushRunner.get(params, GET_METHOD);
        JSONObject jsonResult = jsonMain.getJSONObject("result");
        Gson gson = new Gson();
        return gson.fromJson(jsonResult.toString(), Product.class);
    }

    public void updateProduct(Product product) {
        logger.info("Request: Update the product by id: {}, name: {}", product.getID(), product.getNAME());
        try {
            UriParamsCreator params = new ParamProductUtils().getParamsForUpdateProduct(product);
            PushRunner.post(params, UPDATE_METHOD);
        } catch (UnsupportedEncodingException e) {
            logger.error("An error occurred while updating product", e);
        }
    }
}
