package com.javastream.utils.productSection;

import com.javastream.entity.ProductSection;
import com.javastream.uriParamsCreator.UriParamsCreator;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;


@Service
public class ParamProductSectionUtils {

    private final static String ID = "id";
    private final static String SPACE_PARAM = "%20";
    private final static String NAME = "FIELDS[NAME]";
    private final static String SECTION_ID = "FIELDS[SECTION_ID]";

    public UriParamsCreator getParamsForAddProductSection(ProductSection productSection) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(NAME, check(productSection.getNAME()));
        params.put(SECTION_ID, check(productSection.getSECTION_ID().toString()));
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForDeleteProductSection(Integer idSection) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idSection.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForGetProductSection(Integer idSection) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idSection.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getParamsForUpdateProductSection(ProductSection productSection) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, productSection.getID().toString());
        params.put(NAME, check(productSection.getNAME()));
        params.put(SECTION_ID, check(productSection.getSECTION_ID().toString()));
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