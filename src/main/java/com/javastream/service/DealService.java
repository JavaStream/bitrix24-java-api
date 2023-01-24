package com.javastream.service;

import com.google.gson.Gson;
import com.javastream.entity.Deal;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.PushRunner;
import com.javastream.utils.contact.ParamContactUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * ContactService.
 *
 * @author javastream
 */
public class DealService {

    private Logger logger = LoggerFactory.getLogger(DealService.class);

    private final static String GET_METHOD = "crm.deal.get";

    public Deal get(Integer idDeal) {
        logger.info("Request: Get the deal by id: {}", idDeal);
        UriParamsCreator params = new ParamContactUtils().getMethod(idDeal);
        JSONObject jsonMain = PushRunner.get(params, GET_METHOD);
        JSONObject jsonResult = jsonMain.getJSONObject("result");
        Gson gson = new Gson();
        return gson.fromJson(jsonResult.toString(), Deal.class);
    }
}
