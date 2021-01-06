package com.javastream.entity;

import com.javastream.entity.types.Description_type;
import com.javastream.entity.types.Measure_type;
import lombok.Data;
import lombok.ToString;

/*  Created by JavaStream   */

@Data
@ToString
public class Product {
    private Integer ID;
    private String NAME;
    private String ACTIVE;
    private Integer CREATED_BY;
    private Integer MODIFIED_BY;
    private String CURRENCY_ID;
    private String CATALOG_ID;
    private String DESCRIPTION;
    private String DESCRIPTION_TYPE;
    private String MEASURE;
    private Double PRICE;
    private Integer SECTION_ID;
    private Integer SORT;
    private Integer VAT_ID;
    private String VAT_INCLUDED;
    private String XML_ID;
    private String CODE;
    //private Date DATE_CREATE;
    //private Date DATE_MODIFY;


    public void add_measure(Measure_type measure_type) {
        this.MEASURE = measure_type.getCode();
    }

    public void add_descriptionType(Description_type description_type) {
        this.DESCRIPTION_TYPE = description_type.getCode();
    }

}
