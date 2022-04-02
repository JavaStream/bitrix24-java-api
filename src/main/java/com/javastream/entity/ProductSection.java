package com.javastream.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

/**
 * ProductSection.
 *
 * @author javastream
 */
@Data
@ToString
public class ProductSection {
    @SerializedName("ID")
    private Integer id;

    @SerializedName("CATALOG_ID")
    private Integer catalogId;

    @SerializedName("SECTION_ID")
    private Integer sectionId;

    @SerializedName("NAME")
    private String name;

    @SerializedName("XML_ID")
    private String xmlId;
}