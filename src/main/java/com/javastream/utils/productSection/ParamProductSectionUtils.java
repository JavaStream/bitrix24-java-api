package com.javastream.utils.productSection;

import com.javastream.entity.ProductSection;
import com.javastream.uriParamsCreator.UriParamsCreator;

import java.net.URLEncoder;

/**
 * ParamProductSectionUtils.
 *
 * @author javastream
 */
public class ParamProductSectionUtils {
    private final static String ID = "id";
    private final static String SPACE_PARAM = "%20";
    private final static String NAME = "FIELDS[NAME]";
    private final static String SECTION_ID = "FIELDS[SECTION_ID]";

    public UriParamsCreator addMethod(ProductSection productSection) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(NAME, check(productSection.getName()));
        params.put(SECTION_ID, check(productSection.getSectionId().toString()));
        params.build();
        return params;
    }

    public UriParamsCreator deleteMethod(Integer idSection) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idSection.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getMethod(Integer idSection) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idSection.toString());
        params.build();
        return params;
    }

    public UriParamsCreator updateMethod(ProductSection productSection) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, productSection.getId().toString());
        params.put(NAME, check(productSection.getName()));
        params.put(SECTION_ID, check(productSection.getSectionId().toString()));
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