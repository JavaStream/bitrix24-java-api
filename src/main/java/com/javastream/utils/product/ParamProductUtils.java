package com.javastream.utils.product;

import com.javastream.entity.Product;
import com.javastream.uriParamsCreator.UriParamsCreator;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@Service
public class ParamProductUtils {

    private final static String ID = "id";
    private final static String SPACE_PARAM = "%20";
    private final static String NAME = "FIELDS[NAME]";
    private final static String CURRENCY_ID = "FIELDS[CURRENCY_ID]";
    private final static String DESCRIPTION = "FIELDS[DESCRIPTION]";
    private final static String DESCRIPTION_TYPE = "FIELDS[DESCRIPTION_TYPE]";
    private final static String MEASURE = "FIELDS[MEASURE]";
    private final static String PRICE = "FIELDS[PRICE]";
    private final static String SECTION_ID = "FIELDS[SECTION_ID]";
    private final static String VAT_ID = "FIELDS[VAT_ID]";
    private final static String VAT_INCLUDED = "FIELDS[VAT_INCLUDED]";
    private final static String CODE = "FIELDS[CODE]";

    public UriParamsCreator getParamsForAddProduct(Product product)  {
        UriParamsCreator params = new UriParamsCreator();
        params.put(NAME, check(product.getNAME()));
        params.put(CURRENCY_ID, check(product.getCURRENCY_ID()));
        params.put(DESCRIPTION, check(product.getDESCRIPTION()));
        params.put(DESCRIPTION_TYPE, check(product.getDESCRIPTION_TYPE()));
        params.put(MEASURE, check(product.getMEASURE()));
        params.put(PRICE, product.getPRICE());
        params.put(SECTION_ID, product.getSECTION_ID());
        params.put(VAT_ID, product.getVAT_ID());
        params.put(VAT_INCLUDED, check(product.getVAT_INCLUDED()));
        params.put(CODE, check(product.getCODE()));
        params.build();
        return params;
    }


    public UriParamsCreator getParamsForDeleteProduct(Integer idSection)  {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idSection.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForGetProduct(Integer idSection)  {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idSection.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForUpdateProduct(Product product) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, product.getID().toString());
        params.put(NAME, check(product.getNAME()));
        params.put(CURRENCY_ID, check(product.getCURRENCY_ID()));
        params.put(DESCRIPTION, check(product.getDESCRIPTION()));
        params.put(DESCRIPTION_TYPE, check(product.getDESCRIPTION_TYPE()));
        params.put(MEASURE, check(product.getMEASURE()));
        params.put(PRICE, product.getPRICE());
        params.put(SECTION_ID, product.getSECTION_ID());
        params.put(VAT_ID, product.getVAT_ID());
        params.put(VAT_INCLUDED, check(product.getVAT_INCLUDED()));
        params.put(CODE, check(product.getCODE()));

        params.build();
        return params;
    }


    private String check(String field) {
        if (field == null) {
            return SPACE_PARAM;
        } else {
            return URLEncoder.encode(field.toString());
        }
    }

}