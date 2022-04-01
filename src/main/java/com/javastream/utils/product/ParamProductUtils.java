package com.javastream.utils.product;

import com.javastream.entity.Product;
import com.javastream.uriParamsCreator.UriParamsCreator;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

    public UriParamsCreator addMethod(Product product)  {
        UriParamsCreator params = new UriParamsCreator();
        params.put(NAME, check(product.getName()));
        params.put(CURRENCY_ID, check(product.getCurrencyId()));
        params.put(DESCRIPTION, check(product.getDescription()));
        params.put(DESCRIPTION_TYPE, check(product.getDescriptionType()));
        params.put(MEASURE, check(product.getMeasure()));
        params.put(PRICE, product.getPrice());
        params.put(SECTION_ID, product.getSectionId());
        params.put(VAT_ID, product.getVatId());
        params.put(VAT_INCLUDED, check(product.getVatIncluded()));
        params.put(CODE, check(product.getCode()));
        params.build();
        return params;
    }


    public UriParamsCreator deleteMethod(Integer idSection)  {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idSection.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getMethod(Integer idSection)  {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idSection.toString());
        params.build();
        return params;
    }

    public UriParamsCreator updateMethod(Product product) throws UnsupportedEncodingException {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, product.getId().toString());
        params.put(NAME, check(product.getName()));
        params.put(CURRENCY_ID, check(product.getCurrencyId()));
        params.put(DESCRIPTION, check(product.getDescription()));
        params.put(DESCRIPTION_TYPE, check(product.getDescriptionType()));
        params.put(MEASURE, check(product.getMeasure()));
        params.put(PRICE, product.getPrice());
        params.put(SECTION_ID, product.getSectionId());
        params.put(VAT_ID, product.getVatId());
        params.put(VAT_INCLUDED, check(product.getVatIncluded()));
        params.put(CODE, check(product.getCode()));

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