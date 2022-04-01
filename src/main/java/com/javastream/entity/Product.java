package com.javastream.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

/**
 * Product.
 *
 * @author javastream
 */
@Data
@ToString
public class Product {
    @SerializedName("ID")
    private Integer id;

    @SerializedName("NAME")
    private String name;

    @SerializedName("ACTIVE")
    private String active;

    @SerializedName("CREATED_BY")
    private Integer createdBy;

    @SerializedName("MODIFIED_BY")
    private Integer modifiedBy;

    @SerializedName("CURRENCY_ID")
    private String currencyId;

    @SerializedName("CATALOG_ID")
    private String catalogId;

    @SerializedName("DESCRIPTION")
    private String description;

    @SerializedName("DESCRIPTION_TYPE")
    private String descriptionType;

    @SerializedName("MEASURE")
    private String measure;

    @SerializedName("PRICE")
    private Double price;

    @SerializedName("SECTION_ID")
    private Integer sectionId;

    @SerializedName("SORT")
    private Integer sort;

    @SerializedName("VAT_ID")
    private Integer vatId;

    @SerializedName("VAT_INCLUDED")
    private String vatIncluded;

    @SerializedName("XML_ID")
    private String xmlId;

    @SerializedName("CODE")
    private String code;
}